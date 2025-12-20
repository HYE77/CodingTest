import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> primes = new ArrayList<>();
        boolean[] isPrime = new boolean[4000001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 1; i < 4000001; i++) {
            if (isPrime[i]) {
                primes.add(i);

                // i의 배수 false 처리
                int k = 2;
                while (i * k < 4000001) {
                    isPrime[i*k] = false;
                    k++;
                }
            }
        }

        int start = 0;
        int end = 0;
        int sum = primes.get(0);
        int cnt = isPrime[N] ? 1 : 0;

        while (primes.get(start) < N) {
            if (sum >= N) {
                if (sum == N) cnt++;

                sum -= primes.get(start);
                start++;
            } else {
                end++;
                if (end >= primes.size()) break;
                sum += primes.get(end);
            }
        }

        System.out.println(cnt);
        br.close();
    }
}