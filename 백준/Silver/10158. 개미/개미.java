import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int C = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int currC = Integer.parseInt(st.nextToken());
		int currR = Integer.parseInt(st.nextToken());
		
		int T = Integer.parseInt(br.readLine());
		
		int ansR, ansC;
		
		int rowMod = (T+currR) % (2*R);
		if (rowMod >= R) {
			ansR = R - (rowMod % R);
		} else {
			ansR = rowMod;
		}
		
		int colMod = (T+currC) % (2*C);
		if (colMod >= C) {
			ansC = C - (colMod % C);
		} else {
			ansC = colMod;
		}

		
		bw.write(ansC + " " + ansR);
		bw.flush();
		br.close();
		bw.close();

	}

}
