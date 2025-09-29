import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;
    static int[] cmds; // + - * /
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        cmds = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            cmds[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, nums[0]); // 첫 번째 수로 시작

        bw.write(MAX + "\n" + MIN);
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int depth, int value) {
        if (depth == N - 1) {
            MAX = Math.max(MAX, value);
            MIN = Math.min(MIN, value);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (cmds[i] > 0) {
                cmds[i]--; 
                int next = calc(value, nums[depth + 1], i);
                dfs(depth + 1, next);
                cmds[i]++;
            }
        }
    }

    static int calc(int a, int b, int op) {
        switch (op) {
            case 0: return a + b; // +
            case 1: return a - b; // -
            case 2: return a * b; // *
            case 3: // /
                if (a < 0) return - (Math.abs(a) / b);
                else return a / b;
        }
        return 0;
    }
}
