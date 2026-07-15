import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int[] dp = Arrays.copyOf(land[0], 4);

        for (int i = 1; i < land.length; i++) {
            int[] next = new int[4];

            next[0] = land[i][0]
                    + Math.max(Math.max(dp[1], dp[2]), dp[3]);

            next[1] = land[i][1]
                    + Math.max(Math.max(dp[0], dp[2]), dp[3]);

            next[2] = land[i][2]
                    + Math.max(Math.max(dp[0], dp[1]), dp[3]);

            next[3] = land[i][3]
                    + Math.max(Math.max(dp[0], dp[1]), dp[2]);

            dp = next;
        }

        return Math.max(
                Math.max(dp[0], dp[1]),
                Math.max(dp[2], dp[3])
        );
    }
}