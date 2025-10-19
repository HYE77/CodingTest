import java.io.*;
import java.util.*;

public class Main {

    static int N, S, sum, ans;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        solve(0, 0);
        if (S == 0) ans--;

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }

    static void solve(int sIdx, int sum) {

        if (sIdx == N) {
            if (sum == S) ans++;
            return;
        }

        solve(sIdx+1, sum);
        solve(sIdx+1, sum + nums[sIdx]);

    }
}
