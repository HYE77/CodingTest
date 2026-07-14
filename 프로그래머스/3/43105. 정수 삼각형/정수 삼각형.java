class Solution {
    public int solution(int[][] triangle) {

        int N = triangle.length;
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
        for (int j = 0; j < i+1; j++) {
            dp[i][j] = triangle[i][j];
        }
    }

        for (int i = 1; i < N; i++) {
        for (int j = 0; j < i+1; j++) {
            if (j == 0) {
                dp[i][j] = dp[i][j] + dp[i-1][j];
            } else if (j == i) {
                dp[i][j] = dp[i][j] + dp[i-1][j-1];
            } else {
                int max = Math.max(dp[i-1][j], dp[i-1][j-1]);
                dp[i][j] = dp[i][j] + max;
            }
        }
    }

    int ans = -1;
        for (int n : dp[N-1]) {
        ans = Math.max(ans, n);
    }

        return ans;
    }
}