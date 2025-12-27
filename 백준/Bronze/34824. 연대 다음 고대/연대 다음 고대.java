import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String univ = br.readLine().trim();

            if (univ.equals("yonsei")) {
                System.out.println("Yonsei Won!");
                break;
            } else if (univ.equals("korea")) {
                System.out.println("Yonsei Lost...");
                break;
            }
        }
    }
}