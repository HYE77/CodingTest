import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<String> promise = new ArrayList<>();
        promise.add("Never gonna give you up");
        promise.add("Never gonna let you down");
        promise.add("Never gonna run around and desert you");
        promise.add("Never gonna make you cry");
        promise.add("Never gonna say goodbye");
        promise.add("Never gonna tell a lie and hurt you");
        promise.add("Never gonna stop");

        for (int i = 0; i < N; i++) {
            String input = br.readLine().trim();
            if (!promise.contains(input)) {
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
        br.close();
    }
}