import java.io.*;
import java.util.*;

public class Main {

    static int N, tmp;
    static int[] choice;
    static List<Integer> temp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            N = Integer.parseInt(br.readLine());

            choice = new int[N+1];
            visited = new boolean[N+1];

            st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= N; i++) {
                choice[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    temp = new ArrayList<>();
                    dfs(i, 0);
                    ans += tmp;
                }
            }

            System.out.println(N-ans);
        }

        br.close();
    }

    static void dfs(int idx, int count) {
        if (visited[idx]) {
            if (!temp.contains(idx)) {
                tmp = 0;
                return;
            }
            int from = temp.indexOf(idx);
            tmp = count-from;
            return;
        }

        visited[idx] = true;
        temp.add(idx);
        dfs(choice[idx], count+1);
    }
}
