
import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<Integer>[] adj;
    static int[] parents;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for (int i = 0; i < N+1; i++) {
            adj[i] = new ArrayList<>();
        }
        parents = new int[N+1];

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            adj[from].add(to);
            adj[to].add(from);
        }

        search(1);

        for (int i = 2; i < N+1; i++) {
            sb.append(parents[i]).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void search(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        for (int child : adj[start]) {
            parents[child] = start;
            q.add(child);
        }

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int child : adj[curr]) {
                if (parents[child] == 0) {
                    parents[child] = curr;
                    q.add(child);
                }
            }
        }
    }
}
