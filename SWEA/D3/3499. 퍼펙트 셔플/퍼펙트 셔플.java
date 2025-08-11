
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 int T = Integer.parseInt(br.readLine());
		 for (int t = 1; t <= T; t++) {
			 int N = Integer.parseInt(br.readLine()); // 카드 개수
			 
			 Queue<String> q1 = new LinkedList<>();
			 Queue<String> q2 = new LinkedList<>();
			 
			 String str = br.readLine();
			 
			 String[] cardList = str.split(" ");
			 
			 for (int i = 0; i < N; i++) {
				 if (i < (double) N/2) {
					 q1.add(cardList[i]);
				 } else {
					 q2.add(cardList[i]);
				 }
			 }


			 
			 StringBuilder sb = new StringBuilder();
			 
			 while (!q1.isEmpty()) {
				 sb.append(q1.poll()).append(" ");
				 if (!q2.isEmpty())
					 sb.append(q2.poll()).append(" ");
			 }
			 
			 System.out.println("#" + t + " " + sb);
			 
			 
			 
		 }
	}

}
