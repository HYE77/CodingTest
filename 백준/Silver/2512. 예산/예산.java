import java.util.*;
import java.io.*;

public class Main {
    static int[] demand;
    static int N, dSum, dMax, dMin, total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 지방 수

        demand = new int[N];

        dSum = 0; // 요청 금액 총합
        dMax = 0; // 최대 요청 금액
        dMin = 999999; // 최소 요청 금액
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            demand[i] = Integer.parseInt(st.nextToken());
            dSum += demand[i];
            dMax = Math.max(dMax, demand[i]);
            dMin = Math.min(dMin, demand[i]);
        }

        total = Integer.parseInt(br.readLine()); // 총 예산

        if (dSum <= total) {
            bw.write(dMax + "");
        } else {
            int start = 0;
            int end = dMax;

            while (start <= end) {
                int mid = (start + end) / 2;

                if (cal(mid) <= total) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

            bw.write(end + "");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static int cal(int limit) {
        int sum = 0;
        for (int n : demand) {
            if (n <= limit) sum += n;
            else sum += limit;
        }

        return sum;
    }
}
