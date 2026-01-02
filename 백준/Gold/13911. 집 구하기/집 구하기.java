import java.util.*;
import java.io.*;

public class Main {
    static int V, E, M, S, x, y;
    static boolean[] isMac, isStar; // 맥날/스벅 여부 체크
    static List<Edge>[] edges;
    static final long MAX = 1_000_000_000_000_000L;

    static class Edge implements Comparable<Edge> {
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

        V = Integer.parseInt(st.nextToken()); // 정점 개수
        E = Integer.parseInt(st.nextToken()); // 간선 개수

        isMac = new boolean[V + 1];
        isStar = new boolean[V + 1];
        edges = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) edges[i] = new ArrayList<>();

        // 간선 정보 저장
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            edges[u].add(new Edge(v, w));
            edges[v].add(new Edge(u, w));
        }

        // 맥날 정보 입력
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        List<Integer> macList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int pos = Integer.parseInt(st.nextToken());
            isMac[pos] = true;
            macList.add(pos);
        }

        // 스벅 정보 입력
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        List<Integer> starList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            int pos = Integer.parseInt(st.nextToken());
            isStar[pos] = true;
            starList.add(pos);
        }

        // 다익스트라 2번만 실행 (맥날, 스벅)
        long[] distMac = dijkstra(macList);
        long[] distStar = dijkstra(starList);

        // 정답 계산
        long ans = MAX;
        for (int i = 1; i <= V; i++) {
            // 맥날이거나 스벅이면 건너뛰기
            if (isMac[i] || isStar[i]) continue;

            // 거리 제한 조건 확인
            if (distMac[i] <= x && distStar[i] <= y) {
                ans = Math.min(ans, distMac[i] + distStar[i]);
            }
        }

        System.out.println(ans == MAX ? -1 : ans);
    }

    // 다중 시작점 다익스트라
    static long[] dijkstra(List<Integer> starts) {
        long[] d = new long[V + 1];
        Arrays.fill(d, MAX);
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int start : starts) {
            d[start] = 0;
            pq.add(new Edge(start, 0));
        }

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (d[cur.to] < cur.cost) continue;

            for (Edge e : edges[cur.to]) {
                if (d[e.to] > d[cur.to] + e.cost) {
                    d[e.to] = d[cur.to] + e.cost;
                    pq.add(new Edge(e.to, d[e.to]));
                }
            }
        }
        return d;
    }
}