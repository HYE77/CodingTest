import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int t = 1; t <= T; t++) {
            String str = br.readLine();

            Set<Character> dict = new HashSet<>();

            char[] charArr = str.toCharArray();
            boolean isGroup = true;
            char prev = charArr[0];
            dict.add(prev);
            for (int i = 1; i < charArr.length; i++) {
                if (charArr[i] != prev) {
                    if (dict.contains(charArr[i])) {
                        isGroup = false;
                        break;
                    } else {
                        prev = charArr[i];
                        dict.add(prev);
                    }
                }
            }

            if (isGroup) ans++;
        }

        System.out.println(ans);


    }
}
