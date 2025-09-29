import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        selected = new int[M];

        perm(1, 0);

        bw.write(sb.toString());

        bw.flush();
        br.close();
        bw.close();
    }

    static void perm(int n, int sIdx) {

        if (sIdx == M) {
            for (int s : selected) {
                sb.append(s).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = n; i <= N; i++) {
            selected[sIdx] = i;
            perm(i + 1, sIdx + 1); // 다음은 i보다 큰 수부터
        }


    }
}
