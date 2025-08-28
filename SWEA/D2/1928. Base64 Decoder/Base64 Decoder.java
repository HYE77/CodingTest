import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			String encode = br.readLine();
			char[] arr = encode.toCharArray();
			
			StringBuilder sb = new StringBuilder();
			
			// stringbuilder로 이진수 나열하여 저장하기
			for (char c : arr) {
				sb.append(binary6bit(decode(c)));
			}
			
			// 6비트씩 잘라서 숫자로 변환하기
			List<Integer> ascii = new ArrayList<>();
			
			int N = sb.length() / 8; // N번 돌아야 해 (원본 문자열 길이)
			
			for (int i = 0; i < N; i++) {
				int startIdx = i * 8;
				String part = sb.substring(startIdx, startIdx + 8); // 6개씩 자르기
				int asc = Integer.parseInt(part, 2); // 10진수로 변환
				ascii.add(asc);
			}
			
			// 10진수 -> 문자로 변환
			StringBuilder ans = new StringBuilder();
			for (int a : ascii) {
				ans.append((char) a +"");
			}
			
			// 정답 출력
			bw.write("#" + t + " " + ans.toString());
			bw.flush();
			bw.newLine();
		}
		
		
		bw.close();
		br.close();
	}
	
	public static int decode(char C) {
		// 인코딩 표에 따라 문자를 값으로 바꿔주는 메서드
		if (C >= 'A' && C <= 'Z') {
			return (int) C - 65;
		} else if (C >= 'a' && C <= 'z') {
			return (int) C - 71;
		} else if (C >= '0' && C <= '9') {
			return (int) C + 4;
		} else if (C == '+') {
			return 62;
		} else {
			return 63;
		}
	}
	
	public static String binary6bit(int n) {
		// 인코딩 표의 값(숫자)을 6비트 이진수로 바꿔주는 메서드
		// 1. 2진수로 변환
		String tmp = Integer.toBinaryString(n); 
		
		// 2. 6비트로 늘려주기
		String padding = "";
		for (int i = 0; i < (6-tmp.length()); i++) {
			padding += "0";
		}
		
		return padding + tmp;
	}

}
