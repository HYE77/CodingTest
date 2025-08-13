import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 색종이 수
        int[][] paper = new int[100][100];

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int i = x; i < x+10; i++) {
                for (int j = y; j < y+10; j++) {
                    paper[i][j]++;
                }
            }
        }

        int ans = 0;
        for (int[] row : paper) {
            for (int num : row) {
                if (num > 0) ans++;
            }
        }

        System.out.println(ans);
        br.close();

    }
}
