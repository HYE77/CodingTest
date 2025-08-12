import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringBuilder sb = new StringBuilder();
		String reversed = sb.append(str).reverse().toString();
		
		boolean ans = reversed.equals(str);
		if (ans == true) System.out.println(1);
		else System.out.println(0);
		br.close();
	}

}