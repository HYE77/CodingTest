import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		
		int T = 10;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= T; t++) {
			
			int num = Integer.parseInt(br.readLine()); // tc 날리기
			
			// 원본 배열 만들기
			String[] arr = new String[100];
			for (int i = 0; i < 100; i++) {
				arr[i] = br.readLine();
			}
			
			
			// 가로 회문 체크
			int horMax = 1;
			for (String line : arr) { // 각 행에 대해서
				int lineMax = 1;
				for (int i = 100; i >= 0; i--) { // 각 길이에 대해
					if (hasThisPal(line, i)) { // i 길이의 회문이 있으면
						lineMax = i;
						break;
					}
				}
				if (lineMax > horMax) horMax = lineMax;
				
			}
			
			
			
			// String 뒤집기
			String[] arr2 = new String[100];
			for (int i = 0; i < 100; i++) {
				String temp = "";
				for (int j = 0; j < 100; j++) {
					temp += arr[j].charAt(i);
				}
				arr2[i] = temp;
			}
		
	
			// 세로 회문 체크
			int verMax = 1;
			for (String line : arr2) { // 각 행에 대해서
				int lineMax = 1;
				for (int i = 100; i >= 0; i--) { // 각 길이에 대해
					if (hasThisPal(line, i)) { // i 길이의 회문이 있으면
						lineMax = i;
						break;
					}
				}
				if (lineMax > verMax) verMax = lineMax;
				
			}
			
			
			// 최댓값 도출
			int totalMax;
			
			if (horMax > verMax) totalMax = horMax;
			else totalMax = verMax;
			
			System.out.println("#" + num + " " + totalMax);
		}
		
		
		
		
		
	}
	
	
	public static boolean hasThisPal(String text, int len) {
		StringBuilder sb;
		for (int i = 0; i < 100 - len + 1; i++) { // 시작 인덱스
			sb  = new StringBuilder();
			String subs = text.substring(i, i+len);
			sb.append(subs).reverse();
			if (subs.equals(sb.toString())) return true;
		}
		
		return false;
	}

}
