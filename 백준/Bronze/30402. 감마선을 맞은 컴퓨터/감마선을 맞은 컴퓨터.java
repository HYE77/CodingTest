import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String ans = "";
        for (int i = 0; i < 15; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 15; j++) {
                String c = st.nextToken();
                if (c.equals("r") || c.equals("o") || c.equals("y") ||c .equals("p")) continue;
                if (c.equals("w")) {
                    System.out.println("chunbae");
                    return;
                } if (c.equals("b")) {
                    System.out.println("nabi");
                    return;
                } if (c.equals("g")) {
                    System.out.println("yeongcheol");
                    return;
                }
            }
        }
    }
}