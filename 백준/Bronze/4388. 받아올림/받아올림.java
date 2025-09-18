import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (A.equals("0") && B.equals("0")) break;

            int i = A.length() - 1;
            int j = B.length() - 1;

            int ans = 0;
            int carry = 0;

            // 뒤에서부터 두 수를 비교
            while (i >= 0 || j >= 0) {
                int x = (i >= 0) ? A.charAt(i) - '0' : 0;
                int y = (j >= 0) ? B.charAt(j) - '0' : 0;

                if (x + y + carry >= 10) {
                    ans++;
                    carry = 1;
                } else {
                    carry = 0;
                }

                i--;
                j--;
            }

            bw.write(ans + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
