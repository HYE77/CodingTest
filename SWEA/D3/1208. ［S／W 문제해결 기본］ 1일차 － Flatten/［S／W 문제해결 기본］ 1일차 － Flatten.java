import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int dump = sc.nextInt();
            int[] arr = new int[100];

            // 배열 완성
            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            // 정렬해서 dump
            for (int i = 0; i < dump; i++) {
                arr[99]--;
                arr[0]++;
                Arrays.sort(arr);
            }

            // 결과 출력
            System.out.println("#" + tc + " " + (arr[99] - arr[0]));


        }
    }
}
