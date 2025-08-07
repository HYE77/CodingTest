import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            sc.nextInt();
            int[][] arr = new int[100][100];

            // 사다리 배열 완성하기
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 사다리 타기 시작
            for (int startCol = 0; startCol < 100; startCol++) {
                if (arr[0][startCol] != 1) continue; // 시작지점이 아니면 pass

                int col = startCol;
                int row = 0;
                String dir = "D";

                while (row < 100) {
                    if (dir.equals("D") && col-1 >= 0 && arr[row][col-1] == 1) {
                        col--;
                        dir = "L";
                    } else if (dir.equals("L") && col-1 >= 0 && arr[row][col-1] == 1) {
                        col--;
                    } else if (dir.equals("D") && col+1 < 100 && arr[row][col+1] == 1) {
                        col++;
                        dir = "R";
                    } else if (dir.equals("R") && col+1 < 100 && arr[row][col+1] == 1) {
                        col++;
                    } else {
                        row++;
                        dir = "D";
                    }


                }
                if (arr[99][col] == 2) {
                    System.out.println("#" + tc + " " + startCol);
                    break;
                }
            }


        }
    }
}
