import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int a = 0; a < N-i; a++) {
                bw.write(" ");
            }
            for (int b = 0; b < 2*i-1; b++) {
                bw.write("*");
            }
//            for (int c = 0; c < N-i; c++) {
//                bw.write(" ");
//            }
            bw.newLine();
        }

        for (int i = N-1; i >= 1; i--) {
            for (int a = N-i; a > 0; a--) {
                bw.write(" ");
            }
            for (int b = 2*i-1; b > 0; b-- ) {
                bw.write("*");
            }
//            for (int c = N-i; c > 0; c--) {
//                bw.write(" ");
//            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();


    }
}
