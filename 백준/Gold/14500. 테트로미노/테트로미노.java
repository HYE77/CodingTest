import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int maxValue = 0; // 정답으로 반환할 값
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                // 일반 모양
                visited[r][c] = true;
                dfs(r, c, 1, grid[r][c]);
                visited[r][c] = false;

                // ㅗ 모양
                checkTShape(r, c);
            }
        }

        bw.write(maxValue+"");
        bw.flush();
        br.close();
        bw.close();
    }

    // depth: 현재 포함된 칸 개수 (초기값 1)
    static void dfs(int r, int c, int depth, int sum) {

        if (depth == 4) {
            maxValue = Math.max(maxValue, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;

            visited[nr][nc] = true;
            dfs(nr, nc, depth + 1, sum + grid[nr][nc]);
            visited[nr][nc] = false;
        }
    }

    // (r,c)를 중심으로 ㅗ 모양 처리: 4방향 중 하나씩 제외하고 나머지 3방향의 합을 계산
    static void checkTShape(int r, int c) {
        // 네 방향 중 하나를 제외
        for (int exclude = 0; exclude < 4; exclude++) {
            int sum = grid[r][c];
            boolean ok = true;
            for (int d = 0; d < 4; d++) {
                if (d == exclude) continue;
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    ok = false;
                    break;
                }
                sum += grid[nr][nc];
            }
            if (ok) maxValue = Math.max(maxValue, sum);
        }
    }
}
