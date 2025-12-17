import java.io.*;
import java.util.*;

public class Solution {

    static int N, M;
    static int[][] grid, dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            grid = new int[N][N];
            dp = new int[N+1][N+1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    grid[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1] + grid[i-1][j-1] - dp[i-1][j-1];
                }
            }

            int ans = -1;
            for (int i = M; i <= N; i++) {
                for (int j = M; j <= N; j++) {
                    int tmp = dp[i][j] - dp[i-M][j] - dp[i][j-M] + dp[i-M][j-M];
                    ans = Math.max(ans, tmp);
                }
            }

            System.out.println("#" + t + " " + ans);
        }

        br.close();
    }
}
