import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//		StringTokenizer st;
		
		String input = br.readLine();
		List<Character> oper = new ArrayList<>();
		int operCnt = 0;
		
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) == '-' || input.charAt(i) == '+') {
				operCnt++;
				oper.add(input.charAt(i));
			}
		}
		
		int numCnt = operCnt+1;
		List<Integer> nums = new ArrayList<>();
		
		char[] arr = input.toCharArray();
		int start = 0;
		int i = 0;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			if (i == input.length()-1) {
				nums.add(Integer.parseInt(sb.append(arr[i]+"").toString()));
				break;
			}
			if (arr[i] != '-' && arr[i] != '+') { // 숫자 등장
				sb.append(arr[i]+"");
			} else { // 연산자 등장
				nums.add(Integer.parseInt(sb.toString()));
				sb = new StringBuilder();
			}
			i++;
			
		}
		
		// 묶기
		int ans = nums.get(0);
		int numIdx = 1;
		char status = '+';
		for (int oIdx = 0; oIdx < oper.size(); oIdx++) {
			if (status == '+') {
				if (oper.get(oIdx) == '+') {
					ans += nums.get(numIdx);
					numIdx++;
				} else {
					status = '-';
					ans -= nums.get(numIdx);
					numIdx++;
				}
			} else {
				if (oper.get(oIdx) == '+') {
					ans -= nums.get(numIdx);
					numIdx++;
				} else {
					ans -= nums.get(numIdx);
					numIdx++;
				}
			}
		}
		
		
		
		bw.write(ans+"");
		bw.flush();
		br.close();
		bw.close();

	}

}
