import java.util.*;
import java.io.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs("");
        br.close();
    }

    static void dfs(String result) {
        // 종료 조건
        if (result.length() == N) {
            System.out.println(result);
            System.exit(0);
        }

        for (int k = 1; k <= 3; k++) {
            if (isGood(result + k)) {
                dfs(result + k);
            }
        }
    }

    static boolean isGood(String s) {
        int len = s.length();

        for (int i = 1; i <= len / 2; i++) { // i: back 수열 길이

            String back = s.substring(len - i, len);
            String front = s.substring(len - 2 * i, len - i);

            if (back.equals(front)) return false;
        }
        return true;
    }
}