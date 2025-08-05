import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // testcase  개수
		for (int tc = 0; tc < T; tc++) {
			// 입력받기
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int r1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int r2 = sc.nextInt();
			
			if (x1 == x2 && y1 == y2 && r1 != r2) {
				// 같은 점인데 거리가 다름
				System.out.println(0);
			} else if (x1 == x2 && y1 == y2 && r1 == r2) {
				// 같은 점이고 거리도 같음
				System.out.println(-1);
			} else {
				// 두 점 사이의 거리 계산
				// (x1, y1) --- (x2, y2)
				double distance = Math.sqrt((Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2)));
				
				// r1이 더 크도록 정리
				if (r1 < r2) {
					int temp = r1;
					r1 = r2;
					r2 = temp;
				}
				
				if (distance < r2 && r1 - r2 - distance < 0) {
					// 둘 다 엄청 커
					System.out.println(2);
				} else if (r1 + r2 == distance) {
					// 외접해
					System.out.println(1);
				} else if (r1 + r2 > distance && r1 < distance && r2 < distance) {
					// 각각은 거리보다 작지만 합하면 거리보다 커서 두 점에서 만남
					System.out.println(2);
				} else if (r1 + r2 < distance) {
					// 멀어서 안 만남
					System.out.println(0);
				} else if (r1 > distance && (r1-r2 == distance)) {
					// 내접해 
					System.out.println(1);
				} else if (r1 > distance && (r1-r2 > distance)) {
					// 포함해
					System.out.println(0);
				} else {
					System.out.println(2);
				}

			}

		}
		
		sc.close();
	}

}
