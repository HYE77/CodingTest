import java.util.*;
import java.io.*;

public class Main {

    static int N, M, K;
    static List<Edge>[] adj;
    static long[] dist;
    static int[] interview;

    static class Edge implements Comparable<Edge>{
        int to;
        long cost;

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 도시의 수
        M = Integer.parseInt(st.nextToken()); // 도로의 수
        K = Integer.parseInt(st.nextToken()); // 면접장의 수

        dist = new long[N+1];
        Arrays.fill(dist, Long.MAX_VALUE);
        interview = new int[K];
        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();

        // 도로 정보 입력받기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[from].add(new Edge(to, cost));
        }

        // 면접장 정보
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            interview[i] = Integer.parseInt(st.nextToken());
        }

        // dijkstra
        dijkstra();

        // 정답 출력
        int maxIdx = -1;
        long maxDist = -1;

        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                maxIdx = i;
            }
        }

        System.out.println(maxIdx + "\n" + maxDist);
        br.close();
    }

    static void dijkstra() {

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int start : interview) {
            dist[start] = 0;
            pq.add(new Edge(start, 0));
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (dist[cur.to] < cur.cost) continue;

            for (Edge e : adj[cur.to]) {
                if (dist[e.to] > dist[cur.to] + e.cost) {
                    dist[e.to] = dist[cur.to] + e.cost;
                    pq.add(new Edge(e.to, dist[e.to]));
                }
            }
        }
    }
}