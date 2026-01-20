import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static List<Integer>[] adj;
    static List<Integer> ans;
    static int[] neighborCnt;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
        M = Integer.parseInt(st.nextToken()); // 신뢰 관계
        neighborCnt = new int[N+1];
        visited = new boolean[N+1];
        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            adj[from].add(to);
        }

        ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            Arrays.fill(visited, false);
            dfs(i);

            int tmp = 0;
            for (boolean b : visited) if (b) tmp++;
            neighborCnt[i] = tmp;
        }

        int max = -1;
        for (int n : neighborCnt) max = Math.max(max, n);
        for (int i = 1; i <= N; i++) if (neighborCnt[i] == max) System.out.print(i+" ");

        br.close();
    }

    static void dfs(int node) {
        visited[node] = true;

        for (int n : adj[node]) {
            if  (!visited[n]) dfs(n);
        }
    }
}