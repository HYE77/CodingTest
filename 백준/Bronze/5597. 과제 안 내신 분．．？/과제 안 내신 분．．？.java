import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		List<Integer> arr = new ArrayList<>();
		
		for (int i = 0; i < 28; i++) {
			arr.add(sc.nextInt());
		}
		
		List<Integer> result = new ArrayList<>();
		
		for (int i = 1; i <= 30; i++) {
			if (!arr.contains(i)) {
				result.add(i);
			}
		}
		
		Collections.sort(result);
		
		for (int num : result) {
			System.out.println(num);
		}
		
		sc.close();
	}

}