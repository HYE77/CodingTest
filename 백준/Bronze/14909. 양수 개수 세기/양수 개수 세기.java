import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		String input = br.readLine();
		st = new StringTokenizer(input);
		
		int cnt = 0;
		while (st.hasMoreElements()) {
			if (Integer.parseInt(st.nextToken()) > 0) cnt++;
		}
		
		bw.write(cnt+"");
		bw.flush();
		br.close();
		bw.close();
	}
}	
