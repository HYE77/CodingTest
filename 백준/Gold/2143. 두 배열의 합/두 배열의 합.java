import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long T = Long.parseLong(br.readLine());
        int N = Integer.parseInt(br.readLine());
        long[] arr1 = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr1[i] = Long.parseLong(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        long[] arr2 = new long[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) arr2[i] = Long.parseLong(st.nextToken());

        // 부분 배열의 합 기록
        Map<Long, Integer> map1 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long tmp = arr1[i];
            map1.put(tmp, map1.getOrDefault(tmp, 0)+1);
            for (int j = i+1; j < N; j++) {
                tmp += arr1[j];
                map1.put(tmp, map1.getOrDefault(tmp, 0)+1);
            }
        }

        Map<Long, Integer> map2 = new HashMap<>();
        for (int i = 0; i < M; i++) {
            long tmp = arr2[i];
            map2.put(tmp, map2.getOrDefault(tmp, 0)+1);
            for (int j = i+1; j < M; j++) {
                tmp += arr2[j];
                map2.put(tmp, map2.getOrDefault(tmp, 0)+1);
            }
        }

        // 계산
        long ans = 0;
        for (long key : map1.keySet()) {
            long k = T - key;
            ans += (long) map1.getOrDefault(key, 0) * map2.getOrDefault(k, 0);
        }

        System.out.println(ans);
        br.close();
    }
}