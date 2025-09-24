import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		String IO = "";
		for (int i = 0; i < N; i++) {
			IO += "IO";
		}
		IO += "I";
		
		int ans = 0;
		int idx = 0;
		while (idx < M-(2*N+1)+1) {
			if (S.substring(idx, idx+IO.length()).equals(IO)) ans++;
			idx++;
		}
		
		bw.write(ans+"");
		bw.flush();
		br.close();
		bw.close();
	}
}
