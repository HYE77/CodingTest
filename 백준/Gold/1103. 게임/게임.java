import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] grid, dp; // dp 배열 추가
    static boolean[][] nowTrace; // 사이클 체크용 (기존 visited 역할)
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean isInfinite = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];
        dp = new int[N][M];
        nowTrace = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                if (row.charAt(j) == 'H') grid[i][j] = -1;
                else grid[i][j] = row.charAt(j) - '0';
            }
        }

        int result = dfs(0, 0);

        if (isInfinite) System.out.println(-1);
        else System.out.println(result);

        br.close();
    }

    static int dfs(int r, int c) {
        // 사이클 발견 시
        if (nowTrace[r][c]) {
            isInfinite = true;
            return -1;
        }

        // 이미 계산된 결과가 있다면
        if (dp[r][c] != 0) return dp[r][c];

        nowTrace[r][c] = true; // 현재 경로에 포함 (방문 시작)
        int value = grid[r][c];
        int maxDist = 0;

        for (int d = 0; d < 4; d++) {
            int nr = r + value * dr[d];
            int nc = c + value * dc[d];

            // 경계 밖이거나 구멍인 경우
            if (nr < 0 || nc < 0 || nr >= N || nc >= M || grid[nr][nc] == -1) {
                maxDist = Math.max(maxDist, 1);
                continue;
            }

            int nextDist = dfs(nr, nc);
            if (isInfinite) return -1; // 사이클 전파

            maxDist = Math.max(maxDist, nextDist + 1);
        }

        nowTrace[r][c] = false; // 현재 경로에서 제외
        return dp[r][c] = maxDist; // 결과 저장 및 반환
    }
}