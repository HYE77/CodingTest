import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = new String[5];

        int maxLen = 0;
        for (int i = 0; i < 5; i++) {
            words[i] = br.readLine();
            if (words[i].length() > maxLen) maxLen = words[i].length();
        }

        StringBuilder sb = new StringBuilder();

        for (int c = 0; c < maxLen; c++) {
            for (int r = 0; r < 5; r++) {
                if (words[r].length() > c) {
                    sb.append(words[r].charAt(c));
                }
            }
        }

        System.out.println(sb);

        br.close();

    }
}
