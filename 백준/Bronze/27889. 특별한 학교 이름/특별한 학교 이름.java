import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();

        switch (input) {
            case "NLCS":
                bw.write("North London Collegiate School");
                break;
            case "BHA":
                bw.write("Branksome Hall Asia");
                break;
            case "KIS":
                bw.write("Korea International School");
                break;
            case "SJA":
                bw.write("St. Johnsbury Academy");
                break;
        }


        bw.flush();
        br.close();
        bw.close();
    }
}
