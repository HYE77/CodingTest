import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] title = new String[7];
        int[] cnt = new int[7];

        for (int i = 0; i < 7; i++) {
            st = new StringTokenizer(br.readLine());
            String t = st.nextToken();
            int n = Integer.parseInt(st.nextToken());

            title[i] = t;
            cnt[i] = n;
        }

        String ans = "";
        int max = -1;
        for (int i = 0; i < 7; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                ans = title[i];
            }
        }

        System.out.println(ans);
        br.close();
    }
}
