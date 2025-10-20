import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int C = Integer.parseInt(br.readLine());
        int[] score;
        
        for (int c = 0; c < C; c++) { // each testcase
        	
        	st = new StringTokenizer(br.readLine());
        	
        	int N = Integer.parseInt(st.nextToken());
        	score = new int[N];
        	int sum = 0;
        	
        	for (int i = 0; i < N; i++) {
        		score[i] = Integer.parseInt(st.nextToken());
        		sum += score[i];
        	}
        	
        	double avg = sum / N;
        	
        	int students = 0;
        	for (int n : score) {
        		if (n > avg) students++;
        	}
        	
        	String ans = String.format("%.3f", (float) students/N*100);
        	
        	sb.append(ans).append('%').append('\n');
        	
        }
        
        System.out.println(sb.toString());
        br.close();
    }
}
