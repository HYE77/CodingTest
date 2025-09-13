import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // T자리수

        long[][] dp = new long[T][10]; // row : T자리 수, col : 마지막 자리 수
        // 1행 초기화
        for (int col = 0; col < 10; col++) {
            dp[0][col] = 1;
        }

        // 1열 초기화
        for (int row = 1; row < T; row++) {
            dp[row][0] = 1;
        }

        // 나머지 값 채우기
        for (int row = 1; row < T; row++) {
            for (int col = 1; col < 10; col++) {
                dp[row][col] = (dp[row-1][col] + dp[row][col-1]) % 10007;
            }
        }

        long ans = 0l;
        for (int col = 0; col < 10; col++) {
            ans += dp[T-1][col];
        }

        ans = ans % 10007;

        bw.write(ans+"");

        bw.flush();
        br.close();
        bw.close();
    }

}
