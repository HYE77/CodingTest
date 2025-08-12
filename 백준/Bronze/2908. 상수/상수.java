import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String a = st.nextToken();
		String b = st.nextToken();
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		
		int numA = Integer.parseInt(sb1.append(a).reverse().toString());
		int numB = Integer.parseInt(sb2.append(b).reverse().toString());
		
		
		int ans = Math.max(numA, numB);
		System.out.println(ans);
		
		br.close();
 	}

}