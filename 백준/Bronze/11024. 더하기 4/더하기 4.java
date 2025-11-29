import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            while (st.hasMoreTokens()) sum += Integer.parseInt(st.nextToken());

            System.out.println(sum);
        }
        br.close();
    }
}