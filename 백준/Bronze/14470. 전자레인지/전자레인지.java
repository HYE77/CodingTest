import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		int D = Integer.parseInt(br.readLine());
		int E = Integer.parseInt(br.readLine());
		
		int time = 0;
		boolean melt = false;
		while (A < B) {
			if (A < 0) time += C;
			else if (A == 0 && !melt) {
				time += D;
				melt = true;
				continue;
			} else time += E;
			A++;
		}
		
		bw.write(time+"");
		
		bw.flush();
		br.close();
		bw.close();
	}

}
