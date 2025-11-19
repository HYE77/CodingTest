import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static int[] dp;
    static List<int[]> V;

    static int solve(int here) {
        if (here == m) return 0;
        if (dp[here] != -1) return dp[here];

        int ret = 10000;

        for (int i = here + 1; i < m; i++) {
            // 일정이 겹치면 패스
            if (V.get(i)[0] <= V.get(here)[1]) continue;

            int gap = V.get(i)[0] - V.get(here)[1] - 1;
            ret = Math.min(ret, Math.max(gap, solve(i)));
        }

        // 더 이상 여행을 가지 않는 경우
        ret = Math.min(ret, n - V.get(here)[1]);

        return dp[here] = ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        V = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            V.add(new int[]{s, e});
        }

        // 정렬
        V.sort((a, b) -> a[0] - b[0]);

        dp = new int[m];
        Arrays.fill(dp, -1);

        int ans = 1000;

        for (int i = 0; i < m; i++) {
            int firstGap = V.get(i)[0] - 1;
            ans = Math.min(ans, Math.max(firstGap, solve(i)));
        }

        System.out.println(ans);
        br.close();
    }
}
