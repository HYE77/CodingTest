import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static List<Integer>[] adj;
    static int[] inDegrees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 문제의 수
        M = Integer.parseInt(st.nextToken()); // 정보의 개수

        adj = new ArrayList[N+1]; // 인접리스트
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        inDegrees = new int[N+1]; // 진입차수

        // 정보 개수 입력
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            inDegrees[to]++;
        }

        // 쉬운 문제부터 먼저 풀도록
//        for (int from = 1; from < N; from++) {
//            if (!adj[from].contains(from+1)) {
//                adj[from].add(from+1);
//                inDegrees[from+1]++;
//            }
//        }

        // 순서대로 정렬
        for (int i = 1; i <= N; i++) Collections.sort(adj[i]);

//        System.out.println(Arrays.toString(inDegrees));

        // 위상정렬
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 1; i <= N; i++) {
            if (inDegrees[i] == 0) q.add(i);
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 정렬 결과 저장
            sb.append(cur).append(' ');

            for (int n : adj[cur]) {
                inDegrees[n]--;
                if (inDegrees[n] == 0) q.add(n);
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}