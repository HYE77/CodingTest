import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = "WelcomeToSMUPC".toCharArray();
        int len = arr.length;
        int num = Integer.parseInt(br.readLine());
        if (num % len == 0) System.out.println(arr[len-1]);
        else System.out.println(arr[num%len - 1]);

        br.close();

    }

}