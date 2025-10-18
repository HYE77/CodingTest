import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[][] grid = new long[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Long.parseLong(st.nextToken());
            }
        }

        long[][] dp = new long[N][M];

        // 첫 행 세팅
        dp[0][0] = grid[0][0];
        for (int c = 1; c < M; c++) {
            dp[0][c] = dp[0][c-1] + grid[0][c];
        }

        // dp 탐색
        for (int row = 1; row < N; row++) {
            long[] leftright = new long[M];
            long[] rightleft = new long[M];

            // 왼쪽 -> 오른쪽
            leftright[0] = dp[row-1][0] + grid[row][0];
            for (int c = 1; c < M; c++) {
                leftright[c] = Math.max(leftright[c-1], dp[row-1][c]) + grid[row][c];
            }

            // 오른쪽 -> 왼쪽
            rightleft[M-1] = dp[row-1][M-1] + grid[row][M-1];
            for (int c = M-2; c >= 0; c--) {
                rightleft[c] = Math.max(rightleft[c+1], dp[row-1][c]) + grid[row][c];
            }

            // dp 배열 채우기
            for (int c = 0; c < M; c++) {
                dp[row][c] = Math.max(leftright[c], rightleft[c]);
            }
        }

        bw.write(dp[N-1][M-1]+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
