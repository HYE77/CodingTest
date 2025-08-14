import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine()); //  연산 수
			
			PriorityQueue<Integer> heap = new PriorityQueue<>();
			
			StringBuilder sb = new StringBuilder(); // output 저장
			sb.append("#").append(t).append(" ");
			
			for (int n = 0; n < N; n++) {
				st = new StringTokenizer(br.readLine());
				
				if (Integer.parseInt(st.nextToken()) == 1) { // 추가
					int num = Integer.parseInt(st.nextToken());
					num = -num;
					heap.add(num);
				} else { // 삭제
					if (heap.size() == 0)
						sb.append("-1 ");
					else {
						sb.append(-heap.poll());
						sb.append(" ");
					}
		
				}
			}
			
			System.out.println(sb.toString());
		}
		
		br.close();

	}


}
