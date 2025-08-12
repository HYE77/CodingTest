import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] abcArr = abc.toCharArray();

		Map<Character, Integer> call = new HashMap<>();

		for (char c : abcArr) {
			if (c <= 82)
				call.put(c, (int) (c-56) / 3);
			else
				call.put(c, (int) (c-57) / 3);
		}
		
		call.put('Z', 10);

		String numStr = br.readLine();
		char[] arr = numStr.toCharArray();
		
		int ans = 0;
		
		for (char c : arr) {
			ans += call.get(c);
		}
		
		System.out.println(ans);
		br.close();
	}

}