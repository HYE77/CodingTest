import java.util.*;
import java.io.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int birthY = Integer.parseInt(st.nextToken());
        int birthM = Integer.parseInt(st.nextToken());
        int birthD = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        int currY = Integer.parseInt(st.nextToken());
        int currM = Integer.parseInt(st.nextToken());
        int currD = Integer.parseInt(st.nextToken());
        
        int age1 = 0;
        int age3 = currY - birthY;
        int age2 = age3 + 1;
        
        age1 += currY - birthY;
        if (birthM > currM) age1--;
        else if (birthM == currM) {
        	if (birthD > currD) age1--;
        }
        
        bw.write(age1 + "\n" + age2 + "\n" + age3);
        
       
        bw.flush();
        br.close();
        bw.close();
    }


}
