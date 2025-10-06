import java.io.*;
import java.util.*;

public class Main {

    static int N, E, v1, v2;
    static List<Edge>[] adj;
    static int[] dist;
    static final int INF = 1_000_000_000;
    static class Edge implements Comparable<Edge>{
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 수
        E = Integer.parseInt(st.nextToken()); // 간선 수

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }


        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            adj[from].add(new Edge(to, dist));
            adj[to].add(new Edge(from, dist));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        // v1<->v2 구하기
        dijkstra(v1);
        int v1v2 = dist[v2];

        // 1 -> v1, v2 구하기
        dijkstra(1);
        int fromStart1 = dist[v1];
        int fromStart2 = dist[v2];

        // v1,v2 -> End 구하기
        dijkstra(N);
        int toEnd1 = dist[v1];
        int toEnd2 = dist[v2];

        int case1 = v1v2 + fromStart1 + toEnd2;
        int case2 = v1v2 + fromStart2 + toEnd1;

        int ans;
        if (case1 > INF || case2 > INF || case1 < 0 || case2 < 0) ans = -1;
        else ans = Math.min(case1, case2);

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }

    static void dijkstra(int start) {
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {

            Edge curr = pq.poll();

            for (Edge e : adj[curr.to]) {
                if (dist[e.to] > dist[curr.to] + e.cost) {
                    dist[e.to] = dist[curr.to] + e.cost;
                    pq.add(new Edge(e.to, dist[e.to]));
                }
            }
        }

    }
}
