import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int[][] pool;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        pool = new int[N+2][M+2];

        for (int i = 1; i < N+1; i++) {
            String row = br.readLine();
            for (int j = 1; j < M+1; j++) {
                pool[i][j] = row.charAt(j-1) - '0';
            }
        }

        // 가장 높은 곳부터 살펴보기
        int ans = 0;
        for (int h = 9; h >= 2; h--) {
            // 방문하기
            visited = new boolean[N+2][M+2];
            bfs(h);

            // 물 계산
            for (int i = 1; i < N+1; i++) {
                for (int j = 1; j < M+1; j++) {
                    if (!visited[i][j] && pool[i][j] < h) ans++;
                }
            }
        }

        System.out.println(ans);
        br.close();
    }

    static void bfs(int h) {
        // 높이가 h 미만인 곳을 방문
        // 방문하지 않았으면서 높이가 h미만인 곳에는 물을 채울 수 있다
        Queue<int[]> q = new ArrayDeque<>();
        visited[0][0] = true;
        q.add(new int[] {0, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nc < 0 || nr >= N+2 || nc >= M+2 || visited[nr][nc]) continue;
                if (pool[nr][nc] < h) {
                    visited[nr][nc] = true;
                    q.add(new int[] {nr, nc});
                }
            }
        }
    }
}