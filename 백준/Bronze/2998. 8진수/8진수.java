import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        String prefix = "";
        int cnt = input.length() % 3 == 0 ? 0 : 3 - input.length() % 3;

        if (cnt > 0) {
            for (int i = 0; i < cnt; i++) {
                prefix = prefix.concat("0");
            }
        }

        prefix = prefix.concat(input);

        for (int i = 0; i < prefix.length(); i += 3) {
            String tmp = prefix.substring(i, i+3);
            System.out.print(Integer.parseInt(tmp, 2));
        }
    }
}
