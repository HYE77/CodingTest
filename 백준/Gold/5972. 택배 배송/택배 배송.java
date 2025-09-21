import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
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

        N = Integer.parseInt(st.nextToken()); // 목적지 헛간
        M = Integer.parseInt(st.nextToken()); // 소들의 길
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adj[from].add(new Edge(to, dist));
            adj[to].add(new Edge(from, dist));
        }

        dijkstra(1);
        int ans = dist[N];
        bw.write(ans + "");

        bw.flush();
        br.close();
        bw.close();
    }

    static void dijkstra(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
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
