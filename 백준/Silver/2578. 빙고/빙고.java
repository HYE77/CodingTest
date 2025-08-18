import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int[][] bingo = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] bingoCheck = new int[5][5];
        int cnt = 0;
        for (int i = 0; i < 5; i++) {
            boolean yesBingo = false;
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                cnt++;
                for (int r = 0; r < 5; r++) {
                    boolean found = false;
                    for (int c = 0; c < 5; c++) {
                        if (bingo[r][c] == tmp) {
                            bingoCheck[r][c] = 1;
                            found = true;
                            break;
                        }
                    }
                    if (found) break;
                }
                if (isBingo(bingoCheck)) {
                    yesBingo = true;
                    break;
                }
            }
            if (yesBingo) break;
        }

        bw.write(cnt+"");
        bw.flush();
        bw.close();
        br.close();

    }

    public static boolean isBingo(int[][] bingo) {
        int total = 0;
        // 가로 체크
        for (int[] row : bingo) {
            int sum = 0;
            for (int num : row) {
                sum += num;
            }
            if (sum == 5) total++;
        }
        // 세로 체크
        for (int c = 0; c < 5; c++) {
            int sum = 0;
            for (int r = 0; r < 5; r++) {
                sum += bingo[r][c];
            }
            if (sum == 5) total++;
        }

        // 대각선
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < 5; i++) {
            sum1 += bingo[i][i];
            sum2 += bingo[i][4-i];

        }
        if (sum1 == 5) total++;
        if (sum2 == 5) total++;

        if (total >= 3) return true;
        return false;
    }
}
