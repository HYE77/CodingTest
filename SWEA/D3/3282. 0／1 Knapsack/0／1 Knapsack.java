import java.io.*;
import java.util.*;

public class Solution {

    static int N, K;
    static int[] weights, values;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 물건 개수
            K = Integer.parseInt(st.nextToken()); // 가방 부피

            weights = new int[N+1];
            values = new int[N+1];
            dp = new int[N+1][K+1];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                weights[i] = Integer.parseInt(st.nextToken());
                values[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= N; i++) { // 각 아이템
                for (int j = 0; j <= K; j++) {
                    if (weights[i] <= j) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]]+values[i]);
                    else dp[i][j] = dp[i-1][j]; // 바로 윗줄 내려받기
                }
            }

            System.out.println("#" + t + " " + dp[N][K]);
        }

        br.close();
    }
}
