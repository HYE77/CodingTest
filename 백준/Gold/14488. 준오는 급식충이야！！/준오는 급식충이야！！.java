import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        double T = Double.parseDouble(st.nextToken());
        
        long[] pos = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) pos[i] = Long.parseLong(st.nextToken());
        
        double left = 0;
        double right = Double.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	long speed = Long.parseLong(st.nextToken());
        	
        	left = Math.max(left, pos[i] - speed * T);
        	right = Math.min(right, pos[i] + speed * T);
        }
        
        double eps = 1e-8;
        System.out.println(left <= right + eps ? 1 : 0);
        br.close();
    }
}