import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] grid, dist;
    static final int MAX = 1_000_000_000;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Edge implements Comparable<Edge> {
        int r, c, cost;

        public Edge(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        dist = new int[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = row.charAt(j) - '0';
            }
        }

        for (int[] row : dist) Arrays.fill(row, MAX);

        int ans = dijkstra();

        System.out.println(ans);
        br.close();
    }

    static int dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[0][0] = 0;
        pq.add(new Edge(0, 0, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.r][cur.c] < cur.cost) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if (dist[nr][nc] > dist[cur.r][cur.c] + grid[nr][nc]) {
                    dist[nr][nc] = dist[cur.r][cur.c] + grid[nr][nc];
                    pq.add(new Edge(nr, nc, dist[nr][nc]));
                }
            }
        }

        return dist[N-1][M-1];
    }
}