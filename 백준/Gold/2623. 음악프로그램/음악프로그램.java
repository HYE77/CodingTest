import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 가수의 수
        int M = Integer.parseInt(st.nextToken()); // 보조PD 수

        List<Integer>[] adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        int[] degree = new int[N+1];

        // 선후 관계 정보 입력하기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n-1; j++) {
                int to = Integer.parseInt(st.nextToken());
                adj[from].add(to);
                degree[to]++;
                from = to;
            }
        }

        // 위상정렬
        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new ArrayDeque<>();
        int cnt = 0; // 정렬된 요소 세기
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append('\n');
            cnt++;

            for (int k : adj[cur]) {
                degree[k]--;
                if (degree[k] == 0) q.add(k);
            }
        }

        if (cnt == N) System.out.println(sb.toString());
        else System.out.println(0);

        br.close();
    }
}