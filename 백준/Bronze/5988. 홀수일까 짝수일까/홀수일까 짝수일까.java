import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            BigInteger k = new BigInteger(br.readLine());
            if (k.mod(BigInteger.TWO).equals(BigInteger.ONE)) System.out.println("odd");
            else System.out.println("even");
        }

        br.close();
    }
}