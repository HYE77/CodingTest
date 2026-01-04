import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = (int) Math.pow(Integer.parseInt(br.readLine()), 2);

        if (N <= 100_000_000) System.out.println("Accepted");
        else System.out.println("Time limit exceeded");
    }
}