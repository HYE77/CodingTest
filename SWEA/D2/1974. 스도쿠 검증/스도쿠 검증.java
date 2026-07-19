import java.io.*;
import java.util.*;

class Solution {

    static int[][] sudoku = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            // sudoku 채우기
            for (int i = 0; i < 9; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (horizon() && vertical() && cube()) System.out.println("#" + t + " 1");
            else System.out.println("#" + t + " 0");
        }
    }

    static boolean horizon() {
        boolean[] checked = new boolean[9];

        for (int i = 0; i < 9; i++) {

            Arrays.fill(checked, false);

            for (int j = 0; j < 9; j++) {
                if (checked[sudoku[i][j]-1]) {
                    return false;
                } else {
                    checked[sudoku[i][j]-1] = true;
                }
            }
        }

        return true;
    }

    static boolean vertical() {
        boolean[] checked = new boolean[9];

        for (int j = 0; j < 9; j++) {

            Arrays.fill(checked, false);

            for (int i = 0; i < 9; i++) {
                if (checked[sudoku[i][j]-1]) {
                    return false;
                } else {
                    checked[sudoku[i][j]-1] = true;
                }
            }
        }

        return true;
    }

    static boolean cube() {
        boolean[] checked = new boolean[9];
        int[] pos = {0, 3, 6};

        for (int i : pos) {
            for (int j : pos) {
                Arrays.fill(checked, false);
                for (int a = 0; a < 3; a++) {
                    for (int b = 0; b < 3; b++) {
                        if (checked[sudoku[i+a][j+b]-1]) return false;
                        checked[sudoku[i+a][j+b]-1] = true;
                    }
                }
            }
        }

        return true;
    }
}