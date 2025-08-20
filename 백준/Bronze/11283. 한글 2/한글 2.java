import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st;

        char input = br.readLine().toCharArray()[0];
        int ans = (int) input - 44031;

        bw.write(ans+"");
        bw.flush();
        br.close();
        bw.close();

    }

}
