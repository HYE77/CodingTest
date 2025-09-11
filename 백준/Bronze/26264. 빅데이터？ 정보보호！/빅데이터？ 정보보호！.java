import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        
        input = input.replaceAll("security", "1");
        input = input.replaceAll("bigdata", "2");
        
        int b = 0;
        int s = 0;
        
        for (int i = 0; i < input.length(); i++) {
        	if (input.charAt(i) == '1') s++;
        	else b++;
        }
        
        if (s > b) bw.write("security!");
        else if (s < b) bw.write("bigdata?");
        else bw.write("bigdata? security!");
         
       
        bw.flush();
        br.close();
        bw.close();
    }


}
