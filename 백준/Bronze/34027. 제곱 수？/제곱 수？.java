import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
        	double tmp = Double.parseDouble(br.readLine());
        	
        	if (Math.sqrt(tmp) == (int) Math.sqrt(tmp)) bw.write(1+"\n");
        	else bw.write(0+"\n");
        }
         
       
        bw.flush();
        br.close();
        bw.close();
    }


}
