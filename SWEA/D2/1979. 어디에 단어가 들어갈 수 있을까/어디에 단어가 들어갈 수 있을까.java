import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 퍼즐 길이
            int K = Integer.parseInt(st.nextToken()); // 단어 길이

            int[][] puzzle = new int[N][N];

            for (int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < N; c++) {
                    puzzle[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int sum = 0;
            // 1 -> blank
            // 가로 찾기
            for (int r = 0; r < N; r++) {
                int c = 0;
                while(c < N-K+1) {
                    if (puzzle[r][c] == 1) {
                        int blank = 1;
                        int colIdx = c+1;
                        while (colIdx < N && puzzle[r][colIdx] == 1) {
                            blank++;
                            colIdx++;
                        }
                        if (blank == K) sum++;
                        c = colIdx;
                    } else {
                        c++;
                    }
                }
            }

            // 세로 찾기
            for (int c = 0; c < N; c++) {
                int r = 0;
                while (r < N-K+1) {
                    if (puzzle[r][c] == 1) {
                        int blank = 1;
                        int rowIdx = r+1;
                        while (rowIdx < N && puzzle[rowIdx][c] == 1) {
                            blank++;
                            rowIdx++;
                        }
                        if (blank == K) sum++;
                        r = rowIdx;
                    } else {
                        r++;
                    }

                }
            }

            System.out.println("#" + t + " " + sum);

        }

    }

}
