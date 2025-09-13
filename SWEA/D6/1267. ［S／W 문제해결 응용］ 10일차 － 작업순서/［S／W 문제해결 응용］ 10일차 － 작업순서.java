import java.util.*;
import java.io.*;

public class Solution {

    static int V, E;
    static int[][] adj;
    static int[] inDegree;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = 10;

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken()); // 정점 수
            E = Integer.parseInt(st.nextToken()); // 간선 수

            adj = new int[V+1][V+1];
            inDegree = new int[V+1];

            // 입력 받기 (인접행렬 + 진입차수 정리)
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adj[from][to] = 1;
                inDegree[to]++;
            }

            // 위상정렬
            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= V; i++) {
                if (inDegree[i] == 0) q.add(i);
            }

            bw.write("#" + t + " " );
            while (!q.isEmpty()) {
                int curr = q.poll();

                bw.write(curr + " "); // 출력

                for (int k = 1; k <= V; k++) {
                    if (adj[curr][k] == 1) {
                        inDegree[k]--;
                        if (inDegree[k] == 0) q.add(k);
                    }
                }
            }

            bw.write("\n");


        }


        bw.flush();
        bw.close();
        br.close();
    }

}
