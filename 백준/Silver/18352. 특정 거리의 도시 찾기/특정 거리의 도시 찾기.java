import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K, X;
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

        N = Integer.parseInt(st.nextToken()); // 도시 개수
        M = Integer.parseInt(st.nextToken()); // 도로 개수
        K = Integer.parseInt(st.nextToken()); // 타겟 거리
        X = Integer.parseInt(st.nextToken()); // 출발 도시

        adj = new ArrayList[N+1];
        dist = new int[N+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(new Edge(to, 1));
        }

        dijkstra(X);

        boolean thereis = false;
        for (int i = 1; i < N+1; i++) {
            if (dist[i] == K) {
                bw.write(i + " ");
                thereis = true;
            }
        }

        if (!thereis) bw.write("-1");

        bw.flush();
        br.close();
        bw.close();
    }

    static void dijkstra(int start) {

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];

        pq.add(new Edge(start, 0));
        dist[start] = 0;

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
