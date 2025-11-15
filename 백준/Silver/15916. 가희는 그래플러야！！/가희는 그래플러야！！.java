import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] y1 = new long[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            y1[i] = Long.parseLong(st.nextToken());
        }

        long k = Long.parseLong(br.readLine());

        boolean T = false;
        if (N == 1 && y1[1] == k) T = true;
        else {
            for (int i = 1; i < N; i++) {
                if (y1[i] >= k * i && y1[i + 1] <= k * (i + 1) || y1[i] <= k * i && y1[i + 1] >= k * (i + 1)) {
                    T = true;
                    break;
                }
            }
        }

        if (T) System.out.println("T");
        else System.out.println("F");

        br.close();
    }
}