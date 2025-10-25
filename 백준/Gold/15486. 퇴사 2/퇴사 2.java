import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] days = new int[N + 51];
        int[] costs = new int[N + 51];
        int[] dp = new int[N + 51];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            costs[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = N; i >= 1; i--) {
            if (i + days[i] <= N + 1)
                dp[i] = Math.max(dp[i + 1], costs[i] + dp[i + days[i]]);
            else
                dp[i] = dp[i + 1];
        }

        System.out.println(dp[1]);
        br.close();
    }
}
