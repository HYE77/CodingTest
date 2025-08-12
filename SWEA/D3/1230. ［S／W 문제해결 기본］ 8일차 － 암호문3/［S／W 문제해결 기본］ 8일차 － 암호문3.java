import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) { // each test case
			int N = Integer.parseInt(br.readLine()); // 원본 암호문 뭉치 속 암호문의 개수
			st = new StringTokenizer(br.readLine());
			LinkedList<String> pwd = new LinkedList<>();
			
			// 암호문 뭉치 저장
			for (int i = 0; i < N; i++) {
				pwd.add(st.nextToken());
			}
			
			int command = Integer.parseInt(br.readLine()); // 명령문 개수
			
			// 명령문 돌기
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < command; c++) {
				String cmd = st.nextToken();
				switch (cmd) {
				case "I" :
					int x1 = Integer.parseInt(st.nextToken());
					int y1 = Integer.parseInt(st.nextToken());
					
					for (int i = 1; i < y1+1; i++) {
						pwd.add(x1+i, st.nextToken());
					}
					
					break;
					
				case "D" :
					int x2 = Integer.parseInt(st.nextToken());
					int y2 = Integer.parseInt(st.nextToken());
					
					for (int i = 0; i < y2; i++) {
						pwd.remove(x2);
					}
					
					break;
					
				case "A" :
					int y3 = Integer.parseInt(st.nextToken()); // y3개 암호를 뒤에 추가
					for (int i = 0; i <  y3; i++) {
						pwd.add(st.nextToken());
					}
					
					break;
					
					
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for (int i = 1; i <= 10; i++) {
				String data = pwd.get(i);
				sb.append(data).append(" ");
			}
			
			System.out.println(sb);
			
		}
	}

}
