import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int original = Integer.parseInt(br.readLine());
        int ratio = Integer.parseInt(br.readLine());
        // original * (100-ratio) / 100 * (100 + ans) / 100 = original

        double ans = (double) 10000 / (100 - ratio) - 100;

        System.out.println(ans);
    }
}
