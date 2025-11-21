import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String pw = br.readLine();
            if (pw.length() >= 6 && pw.length() <= 9) System.out.println("yes");
            else System.out.println("no");
        }
        
        br.close();
    }
}