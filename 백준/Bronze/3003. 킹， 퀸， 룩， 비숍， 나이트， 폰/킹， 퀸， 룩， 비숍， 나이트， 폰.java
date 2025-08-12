import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] origin = {1, 1, 2, 2, 2, 8};
        int[] have = new int[6];

        for (int i = 0; i < 6; i++) {
            have[i] = Integer.parseInt(st.nextToken());
            bw.write(origin[i] - have[i] + "");
            bw.write(" ");
        }

        bw.flush();
        bw.close();
        br.close();


    }
}
