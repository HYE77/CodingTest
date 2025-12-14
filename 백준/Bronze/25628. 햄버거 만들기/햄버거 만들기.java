import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int bread = Integer.parseInt(st.nextToken());
        int petty = Integer.parseInt(st.nextToken());

        if (bread >= petty * 2) System.out.println(petty);
        else System.out.println(bread/2);

        br.close();
    }
}