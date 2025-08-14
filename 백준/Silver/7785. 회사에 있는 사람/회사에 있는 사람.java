import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Set<String> office = new TreeSet<>(Collections.reverseOrder());
		
		StringTokenizer st;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String inout = st.nextToken();
			
			if (inout.equals("enter"))
				office.add(name);
			else
				office.remove(name);
		}
		
		
		
		for (String name : office) {
			bw.write(name + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}