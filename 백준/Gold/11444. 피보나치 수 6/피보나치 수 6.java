import java.io.*;
import java.util.*;

public class Main {
	
	static long N;
	static final long MOD = 1_000_000_007L;
	static long[][] A = {{1, 1}, {1, 0}};
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());
        
        // matrix ^ N 수행하기
        long[][] ans = pow(A, N);
        
        
        System.out.println(ans[0][1]);
        br.close();
    }
    
    static long[][] pow(long[][] a, long N) {
    	
    	if (N == 1L) return a;
    	
    	long[][] half = pow(a, N/2);
    	long[][] squared = matmul(half, half);
    	if (N % 2 == 0) return squared;
    	else return matmul(squared, a);
    	
    }
    
    static long[][] matmul(long[][] A, long[][] B) {
    	long[][] result = new long[2][2];
    	for (int i = 0; i < 2; i++) {
    		for (int j = 0; j < 2; j++) {
    			for (int k = 0; k < 2; k++) {
    				result[i][j] += (A[i][k] * B[k][j]) % MOD;
    				result[i][j] %= MOD;
    			}
    		}
    	}
    	
    	return result;   	
    }
}
