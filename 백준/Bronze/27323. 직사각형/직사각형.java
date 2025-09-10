import java.util.*;
import java.io.*;

public class Main {
	
	static int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
	static int[] dc = {0, 1, 0, -1};
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        
        bw.write(A*B+"");
        
        
       
        bw.flush();
        br.close();
        bw.close();
    }


}
