import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			bw.write("#" + t + " ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int tmp = (int) (Math.pow(2, N) - 1);
			
			if ((M & tmp) >= tmp) {
				bw.write("ON");
			} else {
				bw.write("OFF");
			}
			
			bw.flush();
			bw.newLine();
		}
		
		
		bw.close();
		br.close();
	}

}
