import java.io.*;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cmd = Integer.parseInt(br.readLine());
        if (cmd == 0) System.out.println("YONSEI");
        else System.out.println("Leading the Way to the Future");
    }
}