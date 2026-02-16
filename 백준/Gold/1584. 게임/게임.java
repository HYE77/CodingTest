import java.util.*;
import java.io.*;

public class Main {

    static int[][] grid, dist;
    static int N, M;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node>{
        int r, c, cost;

        public Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.cost = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        grid = new int[501][501]; // 0: 안전 1: 위험 2: 죽음
        dist = new int[501][501];

        N = Integer.parseInt(br.readLine()); // 위험한 구역
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int fromR = Math.min(r1, r2);
            int toR = Math.max(r1, r2);
            int fromC = Math.min(c1, c2);
            int toC = Math.max(c1, c2);

            for (int r = fromR; r <= toR; r++) {
                for (int c = fromC; c <= toC; c++) {
                    grid[r][c] = Math.max(grid[r][c], 1);
                }
            }
        }

        M = Integer.parseInt(br.readLine()); // 죽음 구역
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int fromR = Math.min(r1, r2);
            int toR = Math.max(r1, r2);
            int fromC = Math.min(c1, c2);
            int toC = Math.max(c1, c2);

            for (int r = fromR; r <= toR; r++) {
                for (int c = fromC; c <= toC; c++) {
                    grid[r][c] = Math.max(grid[r][c], 2);
                }
            }
        }

        // 경로 탐색 with dijkstra
        dijkstra();
        int ans = dist[500][500] == Integer.MAX_VALUE ? -1 : dist[500][500];

        System.out.println(ans);
    }

    static void dijkstra() {
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = 0;
        pq.add(new Node(0, 0, 0)); // r, c, cost

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (dist[cur.r][cur.c] < cur.cost) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nc < 0 || nr > 500 || nc > 500 || grid[nr][nc] == 2) continue;

                int newCost = cur.cost + grid[nr][nc];

                if (dist[nr][nc] > newCost) {
                    dist[nr][nc] = newCost;
                    pq.add(new Node(nr, nc, dist[nr][nc]));
                }
            }
        }
    }
}