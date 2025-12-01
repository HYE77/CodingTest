import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int ans = 0;
        map.put(input.charAt(right), 1);

        while (left <= right && right < input.length()) {

            // 확인하기
            int cnt = 0;
            for (int value : map.values()) if (value > 0) cnt++;

            // 아웃이라면
            if (cnt > N) {
                map.put(input.charAt(left), map.get(input.charAt(left))-1);
                left++;
                continue;
            }

            // 더 넣을 수 있다면
            ans = Math.max(ans, right-left+1);
            right++;
            if (right >= input.length()) break;
            map.put(input.charAt(right), map.getOrDefault(input.charAt(right), 0)+1);

        }

        System.out.println(ans);
        br.close();
    }
}