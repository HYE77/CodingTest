import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        str = str.replaceAll("c=", "A");
        str = str.replaceAll("c-", "B");
        str = str.replaceAll("dz=", "C");
        str = str.replaceAll("d-", "D");
        str = str.replaceAll("lj", "E");
        str = str.replaceAll("nj", "F");
        str = str.replaceAll("s=", "G");
        str = str.replaceAll("z=", "H");

        char[] arr = str.toCharArray();
        System.out.println(arr.length);

        br.close();


    }
}
