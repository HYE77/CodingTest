import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();
		char[] arr = str.toCharArray();
		
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();
		sb.append(arr).reverse();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}