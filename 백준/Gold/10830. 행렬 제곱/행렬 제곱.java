import java.io.*;
import java.util.*;

public class Main {

    static int A;
    static long B;
    static long[][] matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix = new long[A][A];

        for (int i = 0; i < A; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < A; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] result = pow(matrix, B);

        for (long[] row : result) {
            for (long n : row) {
                sb.append(n).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
        br.close();
    }

    static long[][] pow(long[][] mat, long time) {

        if (time == 1l) {
            for (int i = 0; i < A; i++) {
                for (int j = 0; j < A; j++) {
                    mat[i][j] %= 1000;
                }
            }
            return mat;
        }

        long[][] half = pow(mat, time/2);
        long[][] halfSquared = multiply(half, half);

        if (time % 2 == 0) return halfSquared;
        else return multiply(halfSquared, matrix);

    }

    static long[][] multiply(long[][] X, long[][] Y) {

        long[][] result = new long[A][A];

        for (int i = 0; i < A; i++) {
            for (int j = 0; j < A; j++) {
                for (int k = 0; k < A; k++) {
                    result[i][j] += (X[i][k] * Y[k][j]) % 1000;
                    result[i][j] %= 1000;
                }
            }
        }

        return result;
    }
}
