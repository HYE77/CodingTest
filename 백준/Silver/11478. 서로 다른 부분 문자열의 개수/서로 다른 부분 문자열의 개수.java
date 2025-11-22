import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Set<String> set = new HashSet<>();

        StringBuilder sb;
        for (int i = 1; i <= input.length(); i++) { // 길이
            for (int j = 0; j < input.length()-i+1; j++) { // 시작점
                sb = new StringBuilder();
                for (int k = j; k < j+i; k++) { // 문자열 만들기
                    sb.append(input.charAt(k));
                }
                set.add(sb.toString());
            }
        }

        System.out.println(set.size());
        br.close();
    }
}

