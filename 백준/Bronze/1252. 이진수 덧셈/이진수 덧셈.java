import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        String input1 = st.nextToken();
        String input2 = st.nextToken();
        
        BigInteger a = new BigInteger(input1, 2); // 2진수 해석
        BigInteger b = new BigInteger(input2, 2);
        BigInteger sum = a.add(b);

        bw.write(sum.toString(2)); // 2진수 문자열로 출력
       
        bw.flush();
        br.close();
        bw.close();
    }


}
