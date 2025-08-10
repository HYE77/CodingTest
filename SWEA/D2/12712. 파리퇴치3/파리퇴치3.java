import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // trap size
            int M = Integer.parseInt(st.nextToken()); // spray power

            int[][] trap = new int[N][N];

            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < N; m++) {
                    trap[n][m] = Integer.parseInt(st.nextToken());
                }
            }

            int max1 = plusSpray(trap, N, M);
            int max2 = xSpray(trap, N, M);

            int ans = Math.max(max1, max2);

            System.out.println("#" + t + " " + ans);


        }


    }

    static int plusSpray(int[][] arr, int size, int power) {
        int max = Integer.MIN_VALUE;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                int sum = arr[r][c];
                // 현 위치 : [r][c]
                // 상하
                for (int dr = 1; dr < power; dr++ ) {
                    if (r-dr >= 0) {
                        sum += arr[r-dr][c];
                    }

                    if (r+dr < size) {
                        sum += arr[r+dr][c];
                    }
                }

                // 좌우
                for (int dc = 1; dc < power; dc++ ) {
                    if (c-dc >= 0) {
                        sum += arr[r][c-dc];
                    }
                    if (c+dc < size) {
                        sum += arr[r][c+dc];
                    }
                }


                if (sum > max) max = sum;
            }
        }
        return max;
    }


    static int xSpray(int[][] arr, int size, int power) {
        int max = Integer.MIN_VALUE;

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                // 현 위치 [r][c]
                int sum = arr[r][c];

                for (int d = 1; d < power; d++) {
                    if (r-d >= 0 && c-d >= 0) {
                        sum += arr[r-d][c-d];
                    }
                    if (r-d >= 0 && c+d < size) {
                        sum += arr[r-d][c+d];
                    }
                    if (r+d < size && c-d >= 0) {
                        sum += arr[r+d][c-d];
                    }
                    if (r+d < size && c+d < size) {
                        sum += arr[r+d][c+d];
                    }
                }

                if (sum > max) max = sum;


            }
        }


    return max;

    }


}