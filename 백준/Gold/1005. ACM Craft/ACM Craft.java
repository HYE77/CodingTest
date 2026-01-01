import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine()); // testcase

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 건물 개수
            int M = Integer.parseInt(st.nextToken()); // 규칙 개수

            List<Integer>[] adjList = new ArrayList[N+1];
            for (int i = 1; i <= N; i++) adjList[i] = new ArrayList<>();

            // 소모 시간 기록
            int[] cost = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) cost[i] = Integer.parseInt(st.nextToken());

            // 규칙 기록
            int[] degree = new int[N+1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adjList[from].add(to);
                degree[to]++;
            }

            int W = Integer.parseInt(br.readLine()); // 건설해야 하는 건물

            // 위상 정렬
            Queue<Integer> q = new ArrayDeque<>();
            long[] result = new long[N+1];
            for (int i = 1; i <= N; i++) {
                if (degree[i] == 0) {
                    q.add(i);
                    result[i] = cost[i];
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();

                for (int n : adjList[cur]) {
                    result[n] = Math.max(result[n], result[cur] + cost[n]);
                    degree[n]--;
                    if (degree[n] == 0) q.add(n);
                }
            }

            System.out.println(result[W]);
        }

        br.close();
    }
}