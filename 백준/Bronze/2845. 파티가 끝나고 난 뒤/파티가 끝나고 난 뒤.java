import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken()); // 단위면적 사람 수
        int P = Integer.parseInt(st.nextToken()); // 단위면적 수
        int num = L * P;

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (st.hasMoreElements()) {
            int tmp = Integer.parseInt(st.nextToken());
            sb.append(tmp - num).append(" ");
        }

        System.out.println(sb.toString());

    }

}