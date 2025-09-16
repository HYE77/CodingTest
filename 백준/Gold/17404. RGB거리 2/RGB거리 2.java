import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] rgb = new int[N+1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        int INF = 1_000_000_000;
        int answer = INF;

        for (int first = 0; first < 3; first++) { // 첫 집 색깔이 각각 R, G, B인 경우 비교
            int[][] dp = new int[N+1][3];
            
            // 첫 줄 초기화
            for (int c = 0; c < 3; c++) dp[1][c] = INF; 
            dp[1][first] = rgb[1][first];

            // 점화식 전개
            for (int r = 2; r <= N; r++) {
                dp[r][0] = Math.min(dp[r-1][1], dp[r-1][2]) + rgb[r][0];
                dp[r][1] = Math.min(dp[r-1][0], dp[r-1][2]) + rgb[r][1];
                dp[r][2] = Math.min(dp[r-1][0], dp[r-1][1]) + rgb[r][2];
            }

            // 마지막 집 검사 -> 첫 집과 색 같으면 pass
            for (int last = 0; last < 3; last++) {
                if (last == first) continue;
                answer = Math.min(answer, dp[N][last]);
            }
        }

        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
