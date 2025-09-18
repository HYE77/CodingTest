import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int Q = Integer.parseInt(br.readLine());

        int cnt = 0;
        boolean done = false;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 1) cnt += Integer.parseInt(st.nextToken());
            else cnt -= Integer.parseInt(st.nextToken());
            if (cnt < 0) {
                done = true;
                break;
            }
        }

        if (done) bw.write("Adios");
        else bw.write("See you next month");

        bw.flush();
        br.close();
        bw.close();
    }
}
