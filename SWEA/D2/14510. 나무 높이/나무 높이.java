
import java.util.*;
import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // testcase 수 
		
		for (int t = 1; t <= T; t++) { // 각 test case
			int N = Integer.parseInt(br.readLine()); // 나무의 수
			
			// 나무 배열 만들기
			st = new StringTokenizer(br.readLine());
			
			int[] trees = new int[N];
			
			for (int i = 0; i < N; i++) {
				trees[i] = Integer.parseInt(st.nextToken());
			}
			
			
			// 날짜 계산
			if (isEqual(trees)) { // 이미 다 똑같으면 0 출력
				System.out.println("#" + t + " " + 0);
			} else { // 나무의 길이가 다르다면 
				
				// 최대 높이 구하기
				int max = -1;
				for (int tree : trees) {
					max = Math.max(max, tree);
				}
				
				// 최대 높이와의 차 구하기 -> 배열 gap
				int[] gap = new int[N];
				for (int i = 0; i < N; i++) {
					gap[i] = max - trees[i];
				}

				// case 나누기
				int odd = 0;
				int even = 0;
				
				for (int g : gap) {
					if (g % 2 == 0) even += g / 2;
					else {
						even += g / 2;
						odd++;
					}
				} // 위 for문을 돌고 나오면  even : 짝수(2)일자가 며칠 있는지 / odd : 남은 홀수(1)일자가 며칠 있는지
				
				int ans = 0;

				int temp = Math.max(even - odd, 0) / 3; // even이 더 많다면 3개씩 묶기
				odd += temp * 2; // 2 -> 1, 1 로 바꿔서 odd에 추가해주기
				even -= temp; // 1, 1로 바꾼 2 삭제

				
				if (even >= odd) { // 2가 더 남았으면
					ans = odd * 2;
					ans += (even - odd) / 2 * 3; // 2 2 -> 1 2 1
					ans += (even - odd) % 2 * 2; // 2 남았으면 1 1로 더해주기
				} else { // 1이 더 남았으면
					ans = even * 2;
					ans += (odd - even) * 2 - 1;
				}


				System.out.println("#" + t + " " + ans);
			}
		}
		br.close();
	}
	
	public static boolean isEqual(int[] arr) {
		int size = arr.length;
		
		for (int i = 1; i < size; i++) {
			if (arr[i] != arr[i-1]) return false;
		}
		
		return true;
	}

}

