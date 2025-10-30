import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 수열의 길이
        int K = Integer.parseInt(st.nextToken()); // 삭제할 수 있는 최대 횟수

        st = new StringTokenizer(br.readLine());
        long[] nums = new long[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Long.parseLong(st.nextToken());
        }

        // 이분탐색
        int evenCnt = 0;
        int oddCnt = 0;
        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (left <= right && right < N) {
            if (oddCnt <= K) {
                if (nums[right] % 2 == 0) evenCnt++;
                else oddCnt++;
                right++;
            } else {
                if (nums[left] % 2 == 0) evenCnt--;
                else oddCnt--;
                left++;
            }
            maxLen = Math.max(maxLen, evenCnt);
        }

        System.out.println(maxLen);
        br.close();
    }
}
