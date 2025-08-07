import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			
			int ans = 0; // 반환할 정답 선언
			
			int N = sc.nextInt(); // 건물 개수
			
			int[] arr = new int[N]; // 건물 높이 배열 생성
			
			for (int i = 0; i < N; i++) { // 건물 높이 저장
				arr[i] = sc.nextInt();
			}
			
			for (int b = 2; b < N-2; b++) { // 각 빌딩 순회하며
				int[] neighbors = {arr[b-2], arr[b-1], arr[b+1], arr[b+2]}; // 이웃 층수 저장
				if (arr[b-2] < arr[b] && arr[b-1] < arr[b] && arr[b+1] < arr[b] && arr[b+2] < arr[b]) { // 조망권 확보라면
					int maxNeighbor = -1;
					for (int n : neighbors) { // 이웃 층수 중 최대 층수 탐색
						if (n > maxNeighbor) {
							maxNeighbor = n;
						}
					}
					ans += arr[b] - maxNeighbor;
				} else {
					continue;
				}
			}
			
			System.out.println("#" + tc + " " + ans); // 결과 반환
			
			
		}

		sc.close();
	}

}
