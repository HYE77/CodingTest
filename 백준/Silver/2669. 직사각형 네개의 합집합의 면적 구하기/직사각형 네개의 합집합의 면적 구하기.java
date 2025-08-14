import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] plane = new int[101][101];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int x = x1; x < x2; x++) {
                for (int y = y1; y < y2; y++) {
                    plane[x][y]++;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (plane[i][j] != 0) sum++;
            }
        }

        bw.write(sum+"");
        bw.flush();
        bw.close();
        br.close();

    }
}
