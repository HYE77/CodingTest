import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선
        int N = Integer.parseInt(st.nextToken()); // 만들어야 하는 랜선 개수

        long[] lines = new long[K];
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < K; i++) {
            lines[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lines[i]);
        }

        long left = 1l;
        long right = max;

        while (left <= right) {
            long mid = (left + right) / 2;

            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += lines[i] / mid;
            }

            if (cnt < N) right = mid - 1;
            else left = mid + 1;
        }

        bw.write(right+"");


        bw.flush();
        br.close();
        bw.close();
    }


}
