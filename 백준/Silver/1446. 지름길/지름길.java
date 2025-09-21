import java.util.*;
import java.io.*;

public class Main {

    static int N, D;
    static boolean[] visited;
    static int[] dist;
    static List<Edge>[] adj;

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

        N = Integer.parseInt(st.nextToken()); // 지름길 개수
        D = Integer.parseInt(st.nextToken()); // 고속도로 길이

        visited = new boolean[D+1];
        dist = new int[D+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        adj = new ArrayList[D+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            if (to > D) continue;
            adj[from].add(new Edge(to, dist));
        }

        for (int i = 0; i < D; i++) {
            adj[i].add(new Edge(i+1, 1));
        }

        dijkstra(0);

        int ans = dist[D];
        bw.write(ans+"");

        bw.flush();
        br.close();
        bw.close();
    }

    static void dijkstra(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.add(new Edge(start, 0));

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
