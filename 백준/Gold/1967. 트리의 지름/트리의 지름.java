
import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Node>[] adj;
    static boolean[] visited;
    static int[] dist;

    static class Node {
        int to, dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[from].add(new Node(to, dist));
            adj[to].add(new Node(from, dist));
        }

        // 임의의 점에서 가장 멀리 있는 점 구하기
        visited = new boolean[N+1];
        dist = new int[N+1];
        dist[1] = 0;
        dfs(1);
        int farrest = -1;
        int max = -1;
        for (int i = 1; i <= N; i++) {
            if (dist[i] > max) {
                max = dist[i];
                farrest = i;
            }
        }


        // 트리 지름 구하기
        visited = new boolean[N+1];
        dist = new int[N+1];
        dist[farrest] = 0;
        dfs(farrest);
        int ans = -1;
        for (int d : dist) {
            ans = Math.max(d, ans);
        }

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int start) {
        visited[start] = true;

        for (Node node : adj[start]) {
            if (!visited[node.to]) {
                dist[node.to] = dist[start] + node.dist;
                dfs(node.to);
            }
        }
    }
}
