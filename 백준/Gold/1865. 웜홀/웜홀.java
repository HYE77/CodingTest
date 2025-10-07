import java.io.*;
import java.util.*;

public class Main {

    static int N, M, W;
    static List<Edge> edges;
    static int[] dist;
    static final int INF = 1_000_000_000;
    static boolean negativeCycle;
    static class Edge {
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // testcase 개수

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 정점 수
            M = Integer.parseInt(st.nextToken()); // 도로 수
            W = Integer.parseInt(st.nextToken()); // 웜홀 수

            edges = new ArrayList<>();
            dist = new int[N+1];

            // 일반 도로 입력받기
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges.add(new Edge(from, to, cost));
                edges.add(new Edge(to, from, cost));
            }

            // 웜홀 입력받기
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                edges.add(new Edge(from, to, -cost));
            }

            // 각 지점을 시작점으로 잡고 bellman-ford
            negativeCycle = false;
            for (int start = 1; start <= N; start++) {
                // 초기화
                Arrays.fill(dist, INF);
                dist[start] = 0;

                for (int i = 0; i < N-1; i++) {
                    boolean flag = false;
                    for (Edge e : edges) {
                        if (dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost) {
                            dist[e.to] = dist[e.from] + e.cost;
                            flag = true;
                        }
                    }
                    if (!flag) break; // 조기종료
                }

                // 음수 사이클 체크
                negativeCycle = false;
                for (Edge e : edges) {
                    if (dist[e.from] != INF && dist[e.to]> dist[e.from] + e.cost) {
                        dist[e.to]= dist[e.from]+ e.cost;
                        negativeCycle = true; // 갱신 발생
                    }
                }

                if (negativeCycle) {
                    sb.append("YES").append('\n');
                    break;
                }
            }
            if (!negativeCycle) sb.append("NO").append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
