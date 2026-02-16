import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static char[][] orgn;
    static boolean[][] isAdj; // 쓰레기 옆 칸 여부
    static long[][][] dist; // [r][c][0]: 쓰레기 통과 수, [r][c][1]: 쓰레기 옆 칸 통과 수
    static int startR, startC, endR, endC;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r, c;
        long garbage, adj;

        public Node(int r, int c, long garbage, long adj) {
            this.r = r;
            this.c = c;
            this.garbage = garbage;
            this.adj = adj;
        }

        @Override
        public int compareTo(Node o) {
            if (this.garbage == o.garbage) return Long.compare(this.adj, o.adj);
            return Long.compare(this.garbage, o.garbage);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        orgn = new char[N][M];
        isAdj = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                orgn[i][j] = str.charAt(j);
                if (orgn[i][j] == 'S') {
                    startR = i; startC = j;
                } else if (orgn[i][j] == 'F') {
                    endR = i; endC = j;
                }
            }
        }

        // 쓰레기 인접 칸(adj) 미리 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (orgn[i][j] == 'g') {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        // 빈칸('.')인 경우만! 인접 칸으로 표시 (S, F, g 제외)
                        if (nr >= 0 && nc >= 0 && nr < N && nc < M && orgn[nr][nc] == '.') {
                            isAdj[nr][nc] = true;
                        }
                    }
                }
            }
        }

        // 다익스트라
        dijkstra();

        System.out.println(dist[endR][endC][0] + " " + dist[endR][endC][1]);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist = new long[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], Long.MAX_VALUE);
            }
        }

        dist[startR][startC][0] = 0;
        dist[startR][startC][1] = 0;
        pq.add(new Node(startR, startC, 0, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.r][cur.c][0] < cur.garbage) continue;
            if (dist[cur.r][cur.c][0] == cur.garbage && dist[cur.r][cur.c][1] < cur.adj) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                long nextGarbage = cur.garbage + (orgn[nr][nc] == 'g' ? 1 : 0);
                long nextAdj = cur.adj + (isAdj[nr][nc] ? 1 : 0);

                if (dist[nr][nc][0] > nextGarbage || 
                        dist[nr][nc][0] == nextGarbage && dist[nr][nc][1] > nextAdj) {
                    update(nr, nc, nextGarbage, nextAdj, pq);
                }
            }
        }
    }

    static void update(int r, int c, long g, long a, PriorityQueue<Node> pq) {
        dist[r][c][0] = g;
        dist[r][c][1] = a;
        pq.add(new Node(r, c, g, a));
    }
}