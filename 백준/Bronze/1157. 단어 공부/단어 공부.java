import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		str = str.toUpperCase();
		char[] arr = str.toCharArray();
	
		Map<Character, Integer> dictionary = new HashMap<>();
		for (char c : arr) {
			if (dictionary.containsKey(c)) {
				int currCnt = dictionary.get(c);
				dictionary.put(c, currCnt+1);
			} else {
				dictionary.put(c, 1);
			}
			
		}
		
		Collection<Integer> values = dictionary.values();
		int max = 0;
		for (int v : values) {
			if (v > max) {
				max = v;
			}
		}
		
		int maxChar = 0;
		char ans = ' ';
		for (char key : dictionary.keySet()) {
			if (dictionary.get(key) == max) {
				maxChar++;
				ans = key;
			}
		}
		
		if (maxChar == 1) {
			System.out.println(ans);
		} else {
			System.out.println("?");
		}
 	}

}
