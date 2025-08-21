import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			char[] str = br.readLine().toCharArray();
			String decode = br.readLine();
			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < str.length; i++) {
				if (str[i] == ' ') {
					sb.append(" ");
				} else {
					int idx = (int) str[i] - 65;
					sb.append(decode.charAt(idx)+"");
	
					
				}
			}
			bw.write(sb.toString());
			bw.newLine();
		}
		
		bw.flush();
		br.close();
		bw.close();

	}

}
