import java.util.*;
import java.io.*;

public class Main {

    static int V, E;
    static int[] dist;
    static boolean[] visited;
    static ArrayList<Edge>[] adj;
    static class Edge implements Comparable<Edge> {
        int to, dist;

        public Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수
        int K = Integer.parseInt(br.readLine()); // 시작점
        dist = new int[V+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[V+1];
        adj = new ArrayList[V+1];
        for (int i = 0; i < V+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[from].add(new Edge(to, dist));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            int tmp = dist[i];
            bw.write(tmp == Integer.MAX_VALUE ? "INF\n" : tmp + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void dijkstra(int from) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(from, 0));
        dist[from] = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (visited[curr.to]) continue;
            visited[curr.to] = true;

            for (Edge e : adj[curr.to]) {
                if (!visited[e.to] && dist[e.to] > dist[curr.to] + e.dist) {
                    dist[e.to] = dist[curr.to] + e.dist;
                    pq.add(new Edge(e.to, dist[e.to]));
                }
            }
        }

    }
}
