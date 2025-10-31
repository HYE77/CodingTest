import java.io.*;

public class Main {
    
    static final int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N + 1][10]; // [몇 자리수?][마지막 자리 수]

        // 한자리 수 초기화 -> 모두 1
        for (int i = 1; i <= 9; i++) {
            dp[1][i] = 1;
        }

        // DP
        for (int len = 2; len <= N; len++) {
            for (int last = 0; last <= 9; last++) {
                if (last == 0) dp[len][0] = dp[len - 1][1] % MOD;
                else if (last == 9) dp[len][9] = dp[len - 1][8] % MOD;
                else dp[len][last] = (dp[len - 1][last - 1] + dp[len - 1][last + 1]) % MOD;
            }
        }

        long answer = 0;
        for (int i = 0; i <= 9; i++) {
            answer = (answer + dp[N][i]) % MOD;
        }

        System.out.println(answer);
    }
}
