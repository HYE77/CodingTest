import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정수 개수
        long K = Long.parseLong(st.nextToken()); // 합이 K

        long[] arr = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) arr[i] = Long.parseLong(st.nextToken());

        long[] cumSum = new long[N+1];
        for (int i = 1; i <= N; i++) cumSum[i] = cumSum[i-1] + arr[i];

        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        long ans = 0;

        for (int i = 1; i <= N; i++) {
            long tmpSum = cumSum[i];
            long gap = tmpSum - K;

            long prev = map.getOrDefault(gap, 0L);
            ans += prev;

            map.put(tmpSum, map.getOrDefault(tmpSum, 0L)+1);
        }

        System.out.println(ans);
        br.close();
    }
}