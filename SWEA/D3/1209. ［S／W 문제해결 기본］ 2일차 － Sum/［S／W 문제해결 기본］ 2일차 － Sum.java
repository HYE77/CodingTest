import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            sc.nextInt();

            // 배열 완성하기
            int[][] arr = new int[100][100];
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // 최대 구하기
            int max = 0;

            // 가로합
            for (int[] row : arr) {
                int sum = 0;
                for (int n : row) {
                    sum += n;
                }
                if (sum > max) {
                    max = sum;
                }
            }

            // 세로합

            for (int col = 0; col < 100; col++) {
                int verSum = 0;
                for (int row = 0; row < 100; row++) {
                    verSum += arr[row][col];

                }
                if (verSum > max) {
                    max = verSum;
                }
            }



            // 대각선1
            int diog1 = 0;
            for (int i = 0; i < 100; i++) {
                diog1 += arr[i][i];
            }
            if (diog1 > max) {
                max = diog1;
            }

            // 대각선2
            int diog2 = 0;
            for  (int i = 0; i < 100; i++) {
                diog2 += arr[99-i][i];
            }
            if (diog2 > max) {
                max = diog2;
            }

            // 결과 출력
            System.out.println("#" + tc + " " + max);


        }
    }
}
