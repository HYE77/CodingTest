import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] one = br.readLine().toCharArray();
        char[] two = br.readLine().toCharArray();

        int[][] dp = new int[one.length+1][two.length+1];

        for (int i = 1; i <= one.length; i++) {
            for (int j = 1; j <= two.length; j++) {
                if (one[i-1] == two[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        bw.write(dp[one.length][two.length] + "");


        bw.flush();
        br.close();
        bw.close();
    }

}
