import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
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
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); // 도시 개수
        M = Integer.parseInt(br.readLine()); // 버스 개수
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N+1];
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
        }

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        dijkstra(from);

        bw.write(dist[to]+"");

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
