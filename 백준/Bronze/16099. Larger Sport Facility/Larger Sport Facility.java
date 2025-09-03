import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			long tele = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
			long euro = Long.parseLong(st.nextToken()) * Long.parseLong(st.nextToken());
			if (tele < euro) System.out.println("Eurecom");
			else if (euro < tele) System.out.println("TelecomParisTech");
			else System.out.println("Tie");
		}
		
		br.close();
		bw.close();
	}
}	
