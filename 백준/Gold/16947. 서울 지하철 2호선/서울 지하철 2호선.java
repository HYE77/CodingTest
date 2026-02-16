import java.sql.Array;
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<Integer>[] adj;
    static int[] dist, degree; // 진입 차수
    static boolean[] isCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N + 1];
        degree = new int[N + 1];
        for (int i = 1; i <= N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
            degree[from]++;
            degree[to]++;
        }

        // 사이클 찾기
        findCycle();

        // bfs로 거리 계산
        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) sb.append(dist[i]).append(' ');
        System.out.println(sb.toString());
    }

    static void findCycle() {
        Queue<Integer> q = new LinkedList<>();
        isCycle = new boolean[N + 1];
        Arrays.fill(isCycle, true); // 일단 모두 사이클이라고 가정

        // 연결된 간선이 1개인 노드(리프 노드)를 큐에 삽입
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 1) {
                q.add(i);
                isCycle[i] = false; // 간선이 1개면 절대 사이클이 아님
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj[cur]) {
                degree[next]--; // 연결된 노드의 간선 수 감소
                if (degree[next] == 1) { // 간선이 1개가 되면 사이클 밖으로 판명
                    isCycle[next] = false;
                    q.add(next);
                }
            }
        }
    }

    static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        dist = new int[N + 1];
        Arrays.fill(dist, -1); // 거리를 -1로 초기화하여 방문 여부 체크

        // 사이클에 속한 모든 노드를 동시에 시작점으로 잡음
        for (int i = 1; i <= N; i++) {
            if (isCycle[i]) {
                dist[i] = 0;
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj[cur]) {
                if (dist[next] == -1) { // 아직 방문하지 않은 노드라면
                    dist[next] = dist[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}