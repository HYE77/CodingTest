import java.io.*;
import java.util.*;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static List<Integer> preOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        preOrder = new ArrayList<>();
        
        String line;
        while ((line = br.readLine()) != null) {
            preOrder.add(Integer.parseInt(line));
        }

        postOrder(0, preOrder.size()-1);
       
        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
    
    static void postOrder(int start, int end) {
    	
    	if (start > end) return;
    	
    	int root = preOrder.get(start);
    	int mid = start + 1;
    	
    	while (mid <= end && preOrder.get(mid) < root) mid++;
    	
    	postOrder(start + 1, mid - 1);
    	postOrder(mid, end);
    	sb.append(root).append('\n');
    }
}
