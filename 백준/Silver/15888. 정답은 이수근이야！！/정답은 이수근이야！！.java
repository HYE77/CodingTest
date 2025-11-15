import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        long pbs = B*B - 4*A*C; // 판별식
        if (pbs <= 0) {
            System.out.println("둘다틀렸근");
            return;
        }

        long pbs_sqrt = (long) Math.sqrt(pbs);
        if (pbs_sqrt * pbs_sqrt != pbs) {
            System.out.println("둘다틀렸근");
            return;
        }

        if (!((-B + pbs_sqrt) % (2*A) == 0) || !((-B - pbs_sqrt) % (2*A) == 0)) {
            System.out.println("둘다틀렸근");
            return;
        }
        long ans1 = (-B + pbs_sqrt) / (2*A);
        long ans2 = (-B - pbs_sqrt) / (2*A);

        boolean b1 = ans1 > 1 && (ans1 & (ans1-1)) == 0;
        boolean b2 = ans2 > 1 && (ans2 & (ans2-1)) == 0;
        if (b1 && b2) System.out.println("이수근");
        else  System.out.println("정수근");

        br.close();
    }
}