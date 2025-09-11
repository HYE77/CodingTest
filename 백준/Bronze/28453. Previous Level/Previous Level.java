import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	int tmp = Integer.parseInt(st.nextToken());
        	if (tmp == 300) bw.write(1 + " ");
        	else if (tmp >= 275) bw.write(2 + " ");
        	else if (tmp >=250) bw.write(3 + " ");
        	else bw.write(4 + " ");
        }
         
       
        bw.flush();
        br.close();
        bw.close();
    }


}
