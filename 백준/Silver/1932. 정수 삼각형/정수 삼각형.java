import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] grid = new int[N][N];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = grid[i][j];
            }
        }

        // 누적합 계산
        for (int i = N-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + grid[i][j];
            }
        }

        bw.write(dp[0][0]+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
