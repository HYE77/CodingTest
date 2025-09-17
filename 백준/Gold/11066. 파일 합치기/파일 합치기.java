import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] files;
    static int[] sum; // 파일 크기의 누적합 -> 중간지점을 어디로 잡든 총합은 같음 . .
    static int[][] dp; // 최소 비용

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());
            files = new int[N + 1];
            sum = new int[N + 1];
            dp = new int[N + 1][N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                files[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + files[i]; // 누적누적
            }

            // 길이 2 이상 구간부터 처리 (1인건 고려할 필요X)
            for (int len = 2; len <= N; len++) {
                for (int i = 1; i + len - 1 <= N; i++) { // i : 구간 시작점
                    int j = i + len - 1; // j : 구간 끝점
                    dp[i][j] = Integer.MAX_VALUE;

                    // 최소값 구하기
                    for (int k = i; k < j; k++) { // mid값
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + sum[j] - sum[i - 1]);
                    }
                }
            }

            bw.write(dp[1][N] + "\n");

        }
        bw.flush();
        br.close();
        bw.close();
    }
}
