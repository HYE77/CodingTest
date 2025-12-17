import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[K+1];

        // 순서 : 칼리 -> 링고
        // dp[i] = 현재 숫자가 i일 때, 이번 차례인 사람이 승리할 수 있는 상태인가?
        for (int i = K - 1; i > 0; i--) {
            List<Integer> divisorList = divisors(i);
            boolean flag = false;

            for (int idx : divisorList) {
                // 더해서 K를 넘는다면 넘어가기
                if (i + idx > K) continue;

                // 이동한 위치의 상태가 false(상대방이 지는 상태)라면 현재 상태는 true(내가 이기는 상태)가 됨
                if (!dp[i + idx]) {
                    flag = true;
                    break; // 승리 경로를 하나라도 찾으면 즉시 중단
                }
            }
            
            dp[i] = flag;
        }

        if (dp[1]) System.out.println("Kali");
        else System.out.println("Ringo");
        br.close();
    }

    static List<Integer> divisors(int k) {
        List<Integer> lst = new ArrayList<>();

        for (int i = 1; i <= Math.sqrt(k); i++) {
            if (k % i == 0) {
                lst.add(i);
                if (i * i != k) lst.add(k / i);
            }
        }

        return lst;
    }
}