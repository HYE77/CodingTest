import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품 개수
        int K = Integer.parseInt(st.nextToken()); // 최대 무게

        int[] weights = new int[N+1];
        int[] values = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i < N+1; i++) {
            for (int j = 1; j < K+1; j++) {
                if (j < weights[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weights[i]] + values[i]);
            }
        }

        bw.write(dp[N][K]+"");
        bw.flush();
        br.close();
        bw.close();
    }
}
