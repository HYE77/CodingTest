import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer>[] move = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            move[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            move[from].add(to);
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);

        Queue<int[]> q = new ArrayDeque<>();
        dist[1] = 0;
        q.add(new int[] {1, 0});

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            for (int n : move[cur[0]]) {
                if (dist[n] < 0) {
                    dist[n] = cur[1] + 1;
                    q.add(new int[] {n, cur[1] + 1});
                }
            }
        }

        System.out.println(dist[N]);
    }
}
