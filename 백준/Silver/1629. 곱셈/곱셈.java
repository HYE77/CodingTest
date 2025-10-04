import java.io.*;
import java.util.*;

public class Main {

    static long A, B, C, ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());

        ans = pow(A, B, C);

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();
    }

    static long pow(long a, long b, long c) {
        if (b == 0) return 1;          // a^0 = 1
        long half = pow(a, b / 2, c);  // A^(B/2)
        long result = (half * half) % c; // (A^(B/2))^2 % C
        if (b % 2 == 1) result = (result * a) % c; // B가 홀수면 A 한 번 더 곱하기
        return result;
    }


}
