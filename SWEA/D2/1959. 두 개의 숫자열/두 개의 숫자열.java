import java.util.Scanner;

class Solution {

	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

//			값 받아오기
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[] numN = new int[N];
			int[] numM = new int[M];

			for (int i = 0; i < N; i++) {
				numN[i] = sc.nextInt();
			}

			for (int i = 0; i < M; i++) {
				numM[i] = sc.nextInt();
			}

//			작은 크기의 배열을 돌면서 값 계산 > 최댓값 출력
			int max = 0;

//			N < M
			if (N < M) {

				for (int i = 0; i < M - N + 1; i++) {
					int sum = 0;

					for (int j = 0; j < N; j++) {
						sum += numN[j] * numM[i+j];
					}
					max = Math.max(max, sum);

				}
			} 
//			M < N
			else {
				for (int i = 0; i < N - M + 1; i++) {
					int sum = 0;

					for (int j = 0; j < M; j++) {
						sum += numN[i+j] * numM[j];
					}
					max = Math.max(max, sum);
				}
			}

			System.out.println("#" + test_case + " " + max);

		}
	}

}