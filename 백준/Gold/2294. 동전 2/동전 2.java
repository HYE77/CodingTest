import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 동전 종류
        int k = Integer.parseInt(st.nextToken()); // 총 금액

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(coins);
        int[][] dp = new int[n][k+1];

        for (int c = 1; c <= k; c++) {
            dp[0][c] = c % coins[0] == 0 ? c/coins[0] : 1_000_000_000;
        }

        for (int coin = 1; coin < n; coin++) {
            for (int m = 0; m <= k; m++) {
                if (m < coins[coin]) dp[coin][m] = dp[coin-1][m];
                else dp[coin][m] = Math.min(dp[coin-1][m], dp[coin][m-coins[coin]] + 1);
            }
        }

        int ans = dp[n-1][k] == 1_000_000_000 ? -1 : dp[n-1][k];
        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
