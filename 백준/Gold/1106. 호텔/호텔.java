import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken()); // 목표 인원
        int N = Integer.parseInt(st.nextToken()); // 도시 수

        int[] cost = new int[N];
        int[] people = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int maxTarget = C + 100;
        int[] dp = new int[maxTarget + 1];
        Arrays.fill(dp, 1_000_000_000);
        dp[0] = 0;

        for (int i = 0; i < N; i++) { // 각 비용-인원 쌍
            for (int j = people[i]; j <= maxTarget; j++) { // 총 인원
                dp[j] = Math.min(dp[j], dp[j - people[i]] + cost[i]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = C; i <= maxTarget; i++) {
            ans = Math.min(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
