import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long N =  Integer.parseInt(br.readLine());
		
		System.out.println(fact(N));
		
		br.close();
	}
	
	public static long fact(long N) {
		if (N <= 1) return 1;
		return fact(N-1) * N;
	}
	
}