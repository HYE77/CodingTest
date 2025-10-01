import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb;
    static int N, M;
    static boolean[] visited;
    static int[] nums, selected;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        selected = new int[M];

        solve(0);

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }

    static void solve(int sIdx) {

        if (sIdx == M) {
            for (int n : selected) {
                sb.append(n).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;

            selected[sIdx] = nums[i];
            visited[i] = true;
            solve(sIdx + 1);
            visited[i] = false;
        }
    }

}
