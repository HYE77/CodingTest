import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        long answer = 0;

        for (int k = 0; k < M; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long S = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            // 모듈러 역원: S^(MOD-2)
            long invS = modPow(S, MOD - 2);

            // C * S^{-1} mod
            long val = (C % MOD) * invS % MOD;

            answer = (answer + val) % MOD;
        }

        System.out.println(answer);
    }

    // 빠른 거듭제곱 (O(log MOD))
    static long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }

        return result;
    }
}
