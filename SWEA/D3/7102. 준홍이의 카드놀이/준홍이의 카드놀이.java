import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] arr = new int[N+M+1];

            for (int n = 1; n <= N; n++) {
                for (int m = 1; m <= M; m++) {
                    arr[m+n]++;
                }
            }

            int maxCnt = 0;

            for (int i = 1; i <= N+M; i++) {
                if (arr[i] > maxCnt) {
                    maxCnt = arr[i];
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");

            for (int i = 1; i <= N+M; i++) {
                if (arr[i] == maxCnt) {
                    sb.append(i).append(" ");
                }
            }

            System.out.println(sb);

        }

    }
}