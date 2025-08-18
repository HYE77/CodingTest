
import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st1, st2;
		
		int N = Integer.parseInt(br.readLine()); // 몇 라운드?
		for (int n = 1; n <= N; n++) {
			int[] cardA = new int[4];
			int[] cardB = new int[4];
			
			st1 = new StringTokenizer(br.readLine());
			int nA = Integer.parseInt(st1.nextToken());
			for (int i = 0; i < nA; i++) {
				int temp = Integer.parseInt(st1.nextToken());
				cardA[4-temp] += 1;
			}
			
			st2 = new StringTokenizer(br.readLine());
			int nB = Integer.parseInt(st2.nextToken());
			for (int i = 0; i < nB; i++) {
				int temp = Integer.parseInt(st2.nextToken());
				cardB[4-temp] += 1;
			}
			
			char ans = 'D';
			
			for (int i = 0; i < 4; i++) {
				if (cardA[i] > cardB[i]) {
					ans = 'A';
					break;
				} else if (cardA[i] < cardB[i]) {
					ans = 'B';
					break;
				} 
			}
			
			bw.write(ans+"");
			bw.newLine();
			bw.flush();
			
			
		}
		br.close();
		bw.close();
	}

}
