import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n + 1][n + 1];
        int[][] route = new int[n + 1][n + 1];

        for (int[] d : dist) Arrays.fill(d, INF);
        for (int i = 1; i <= n; i++) dist[i][i] = 0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (dist[from][to] > cost) {
                dist[from][to] = cost;
                route[from][to] = to; // 첫 경로 설정
            }
        }

        // 플로이드-워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] == INF || dist[k][j] == INF) continue;
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        route[i][j] = route[i][k]; // 중간 경로 갱신
                    }
                }
            }
        }

        // 거리 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) sb1.append("0 ");
                else sb1.append(dist[i][j]).append(' ');
            }
            sb1.append('\n');
        }

        // 경로 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == 0 || dist[i][j] == INF) {
                    sb2.append("0\n");
                    continue;
                }

                List<Integer> path = new ArrayList<>();
                int cur = i;
                path.add(cur);
                while (cur != j) {
                    cur = route[cur][j];
                    path.add(cur);
                }

                sb2.append(path.size()).append(' ');
                for (int city : path) sb2.append(city).append(' ');
                sb2.append('\n');
            }
        }

        bw.write(sb1.toString());
        bw.write(sb2.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}
