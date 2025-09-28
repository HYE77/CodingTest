import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] scores = new int[N+1];
        for (int i = 1; i <= N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N+1];

        dp[0] = 0;
        dp[1] = scores[1];
        if (N > 1) {
            dp[2] = scores[1] + scores[2];
            for (int i = 3; i <= N; i++) {
                dp[i] = Math.max(dp[i-3] + scores[i-1], dp[i-2]) + scores[i];
            }
        }

        bw.write(dp[N]+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
