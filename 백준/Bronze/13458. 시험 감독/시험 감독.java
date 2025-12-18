import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 시험장 개수
        int[] arr = new int[N]; // 각 시험장 응시자 수
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); // 감독관이 감시 가능한 인원 수
        int C = Integer.parseInt(st.nextToken()); // 부감독관이 김시할 수 있는 인원 수

        long cnt = 0L;
        for (int n : arr) {
            if (n <= B) {
                cnt++;
                continue;
            }

            cnt++;
            n -= B;
            if (n <= 0) break;

            cnt += n / C;
            n %= C;

            cnt += n > 0 ? 1 : 0;
        }

        System.out.println(cnt);
        br.close();
    }
}