import java.util.*;
import java.io.*;

public class Main {

	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
       int M = Integer.parseInt(st.nextToken()); // 행
       int N = Integer.parseInt(st.nextToken()); // 열
       
       if (M <= N) bw.write(2 * (M-1) +"");
       else bw.write(2 * (N-1) + 1 +"");
       
       
       
        bw.flush();
        br.close();
        bw.close();
    }

}

