import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String num1 = br.readLine();
            String num2 = br.readLine();
            int len = num1.length();

            int cnt = 0;
            for (int c = 0; c < len; c++) {
                if (num1.charAt(c) != num2.charAt(c)) cnt++;
            }

            System.out.println("Hamming distance is " + cnt + ".");
        }
    }
}
