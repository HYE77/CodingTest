import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < 3; i++) {
			arr.add(sc.nextInt());
		}
		
		Collections.sort(arr);
		
		int ans;
		
		if (arr.get(0) == arr.get(1) && arr.get(1) == arr.get(2)) {
			ans = 10000 + 1000 * arr.get(0);
		} else if (arr.get(0) != arr.get(1)  && arr.get(1) != arr.get(2)) {
			ans = 100 * arr.get(2);
		} else {
			if (arr.get(0) == arr.get(1)) {
				ans = 1000 + 100 * arr.get(1);
			} else {
				ans = 1000 + 100 * arr.get(2);
			}
		}
		
		System.out.println(ans);
		
		sc.close();
 	}

}