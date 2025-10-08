import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    static int V;
    static List<Edge>[] adj;
    static boolean[] visited;
    static int[] dist;

    static class Edge {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        V = Integer.parseInt(br.readLine()); // 정점 수
        dist = new int[V+1];
        visited = new boolean[V+1];
        adj = new ArrayList[V+1];
        for (int i = 1; i < V+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                adj[from].add(new Edge(to, cost));
            }
        }

        // 임의의 점에서 가장 먼 정점 구하기
        dfs(1);
        int maxIdx = -1;
        int maxValue = -1;
        for (int i = 1; i < V+1; i++) {
            if (dist[i] > maxValue) {
                maxValue = dist[i];
                maxIdx = i;
            }
        }

        // 트리의 지름 구하기
        Arrays.fill(dist, 0);
        Arrays.fill(visited, false);
        dfs(maxIdx);

        int ans = -1;
        for (int i = 1; i < V+1; i++) {
            ans = Math.max(dist[i], ans);
        }

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int start) {
        Queue<Edge> q = new ArrayDeque<>();
        q.add(new Edge(start, 0));
        visited[start] = true;

        while (!q.isEmpty()) {
            Edge curr = q.poll();

            for (Edge e : adj[curr.to]) {
                if (!visited[e.to]) {
                    dist[e.to] = dist[curr.to] + e.cost;
                    visited[e.to] = true;
                    q.add(new Edge(e.to, dist[e.to]));
                }
            }
        }

    }
}
