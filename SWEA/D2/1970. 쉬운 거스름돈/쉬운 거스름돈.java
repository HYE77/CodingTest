import java.util.*;
import java.io.*;

public class Solution {
    static int[] coins = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
    static int[] ansList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append("\n");
            int total =Integer.parseInt(br.readLine()); // 총액
            ansList = new int[8];

            for (int i = 0; i < 8; i++) {
                ansList[i] = total / coins[i];
                total %= coins[i];
            }

            for (int n : ansList) {
                sb.append(n).append(" ");
            }

            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

}
