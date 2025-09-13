import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            int N = Integer.parseInt(br.readLine());

            int[][] stickers = new int[2][N+1];
            stickers[0][0] = 0;
            stickers[1][0] = 0;

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[2][N+1];

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];


            for (int j = 2; j <= N; j++) {

                dp[0][j] = Math.max(dp[1][j-1] + stickers[0][j], dp[1][j-2] + stickers[0][j]);
                dp[1][j] = Math.max(dp[0][j-1] + stickers[1][j], dp[0][j-2] + stickers[1][j]);
            }

            int ans = Math.max(dp[0][N], dp[1][N]);
            bw.write(ans+"\n");

        }

        bw.flush();
        br.close();
        bw.close();
    }


}
