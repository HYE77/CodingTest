import java.io.*;
import java.util.*;

public class Main {

    static int N, T;
    static int[] result;
    static boolean[] visited;
    static List<int[]>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 최대한 많은 문제를 풀어야 해!! -> dfs 깊이를 최대로 해야 함

        N = Integer.parseInt(st.nextToken()); // 문제 수
        T = Integer.parseInt(st.nextToken()); // 하루 풀이 시간

        visited = new boolean[N+1];

        adj = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            adj[from].add(new int[] {to, time});
            adj[to].add(new int[] {from, time});

        }

        // 답을 찾아보자
        // depth가 최대일 때의 가중치의 합(tmp)를 구하자
        // depth가 같다면 가중치의 합이 작아야 함
        // 즉, 트리의 지름과 같은 길이를 가지는 경로 중 가중치의 합이 최소인 경우를 찾아야 함

        // 트리의 지름 구하기
        // 첫 번재 끝 점 찾기
        result = new int[3];
        Arrays.fill(visited, false);
        Arrays.fill(result, 0);
        visited[1] = true;
        dfs(1, 0, 0);
        int firstNode = result[0];

        // 다른 끝 점을 찾아 DFS
        Arrays.fill(visited, false);
        Arrays.fill(result, 0);
        visited[firstNode] = true;
        dfs(firstNode, 0, 0);
        int sumWeight = result[2];

        System.out.println((sumWeight+T-1) / T);
        br.close();
    }

    static void dfs(int node, int depth, int sum) {
        // result -> node, depth, sum of weight
        if (depth > result[1] || depth == result[1] && sum < result[2]) {
            result[0] = node;
            result[1] = depth;
            result[2] = sum;
        }

        for (int[] edge : adj[node]) {
            if (!visited[edge[0]]) {
                visited[edge[0]] = true;
                dfs(edge[0], depth+1, sum+edge[1]);
            }
        }
    }

}