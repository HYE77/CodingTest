import java.io.*;
import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] grid, dist, visited;
    static int[] start = new int[2];
    static Queue<int[]> mnq = new ArrayDeque<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); // 마네킹과의 거리가 K 이하면 못 가

        grid = new int[N][M];
        dist = new int[N][M];
        visited = new int[N][M];

        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        for (int[] row : visited) Arrays.fill(row, Integer.MAX_VALUE);

        // 입력 받기
        // 0: 빈칸, 1: 기둥, 2: 의자, 3: 마네킹, 4: 시작 지점
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                grid[i][j] = v;

                if (v == 1) visited[i][j] = Integer.MIN_VALUE; // 기둥이면 못 가
                else if (v == 3) { // 마네킹이라면 enqueue
                    visited[i][j] = Integer.MIN_VALUE; // 마네킹도 못 가
                    mnq.add(new int[] {i, j, 0});
                } else if (v == 4) { // 시작 지점 저장
                    start[0] = i;
                    start[1] = j;
                    visited[i][j] = Integer.MIN_VALUE;
                }
            }
        }

        // 마네킹과의 거리 입력하기 (bfs)
        while (!mnq.isEmpty()) {
            int[] cur = mnq.poll();

            if (cur[2] == K) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || dist[nr][nc] <= K) continue;

                dist[nr][nc] = cur[2]+1;
                mnq.add(new int[] {nr, nc, cur[2]+1});
            }
        }

        // 의자 찾기
        Queue<int[]> q = new ArrayDeque<>();
        visited[start[0]][start[1]] = Integer.MIN_VALUE;;
        q.add(new int[] {start[0], start[1], 0}); // {i, j, 소모체력}

        int ans = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int[] cur = q.poll();

            // 의자에 도달했다면
            if (grid[cur[0]][cur[1]] == 2) {
                ans = Math.min(cur[2], ans);
                continue;
            }

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] <= cur[2]+1 || dist[nr][nc] <= K) continue;

                visited[nr][nc] = cur[2]+1;
                q.add(new int[] {nr, nc, cur[2]+1});
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
        br.close();
    }
}
