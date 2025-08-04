import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] m1 = new int[N][M];
		int[][] m2 = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				m1[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				m2[i][j] = sc.nextInt();
			}
		}
		

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print((m1[i][j] + m2[i][j]) + " ");
			}
			System.out.println();
		}
		
		
		
		
		sc.close();
	}

}