import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N =  Integer.parseInt(br.readLine());
		
		System.out.println(fib(N));
		
		br.close();
	}
	
	public static long fib(long N) {
		if (N == 0) return 0;
		if (N == 1) return 1;
		return fib(N-1) + fib(N-2);
	}
	
}