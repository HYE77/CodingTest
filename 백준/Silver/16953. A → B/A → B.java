import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());

        Queue<long[]> q = new ArrayDeque<>();
        q.add(new long[] {A, 0});
        long ans = -1;

        while (!q.isEmpty()) {

            long[] curr = q.poll();
            if (curr[0] == B) {
                ans = curr[1] + 1;
                break;
            }

            if (curr[0] * 2 <= B) q.add(new long[] {curr[0]*2, curr[1] + 1});

            if (curr[0]*10 + 1 <= B) q.add(new long[] {curr[0]*10 + 1, curr[1] + 1});
        }

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }

}
