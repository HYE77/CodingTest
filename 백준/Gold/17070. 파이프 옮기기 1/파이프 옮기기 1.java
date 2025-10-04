
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] grid;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        dp = new int[N][N][3]; // 마지막 3 -> 가로(0), 세로(1), 대각선(2)

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // DP 배열 채우기
        dp[0][1][0] = 1; // 초기값
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (grid[r][c] == 1) continue;

                // 가로로 도달하는 경우
                if (c - 1 >= 0 && grid[r][c - 1] == 0) {
                    dp[r][c][0] += dp[r][c - 1][0] + dp[r][c - 1][2];
                }

                // 세로로 도달하는 경우
                if (r - 1 >= 0 && grid[r - 1][c] == 0) {
                    dp[r][c][1] += dp[r - 1][c][1] + dp[r - 1][c][2];
                }

                // 대각선으로 도달하는 경우
                if (r - 1 >= 0 && c - 1 >= 0 &&
                        grid[r - 1][c] == 0 && grid[r][c - 1] == 0 && grid[r - 1][c - 1] == 0) {
                    dp[r][c][2] += dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
                }
            }
        }

        long ans = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
