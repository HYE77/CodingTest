import java.io.*;
import java.util.*;

public class Main {

    // 단어를 key 형태로 변환
    // 첫 글자 + (중간 글자 정렬) + 마지막 글자
    static String toKey(String word) {
        int len = word.length();
        if (len <= 2) return word; // 그대로 key

        char[] mid = word.substring(1, len - 1).toCharArray();
        Arrays.sort(mid);
        return word.charAt(0) + new String(mid) + word.charAt(len - 1);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> dict = new HashMap<>();

        // 사전 단어 처리
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            String key = toKey(word);
            dict.put(key, dict.getOrDefault(key, 0) + 1);
        }

        int M = Integer.parseInt(br.readLine());

        // 문장 처리
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long ans = 1;

            while (st.hasMoreTokens()) {
                String w = st.nextToken();
                String key = toKey(w);

                ans *= dict.getOrDefault(key, 0);
            }

            System.out.println(ans);
        }
    }
}
