import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        // 신발끈 공식을 이용하자
        int N = Integer.parseInt(br.readLine());
        
        long[] X = new long[N+1];
        long[] Y = new long[N+1];
        
        for (int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	long x = Long.parseLong(st.nextToken());
        	long y = Long.parseLong(st.nextToken());
        	
        	 X[i] = x;
        	 Y[i] = y;       	
        }
        
        X[N] = X[0];
        Y[N] = Y[0];
        
        long upDown = 0;
        long downUp = 0;
        
        for (int i = 0; i < N; i++) {
        	upDown += X[i] * Y[i+1];
        	downUp += Y[i] * X[i+1];
        }
        
        BigDecimal diff = BigDecimal.valueOf(Math.abs(upDown - downUp));
        BigDecimal ans = diff.divide(BigDecimal.valueOf(2), 1, RoundingMode.HALF_UP);
        
        System.out.println(ans.toPlainString());

        br.close();
    }
}