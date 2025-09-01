import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] arr = new int[1000000];
	static int[] tmp = new int[1000000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < 1000000; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        
        mergeSort(0, 999999);
        
        
        System.out.println(arr[500000]);
   
        
    }
    
    
	static void mergeSort(int start, int end) {
		if (start >= end)  return;
		
		
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(start, mid);
			mergeSort(mid+1, end);
			
			merge(start, mid, end);
			
		}
	}
	
	static void merge(int start, int mid, int end) {
		int L = start;
		int R = mid +1;
		
		int idx = start;
		
		while (L <= mid && R <= end) {
			// 둘 중 하나라도 구간을 벗어나면 그만해!
			// 등호 덕분에 안정정렬 가능!
			if (arr[L] <= arr[R]) {
				tmp[idx] = arr[L];
				idx++;
				L++;
			} else {
				tmp[idx++] = arr[R++];
			} 
		} // 한쪽 구간 완료
		
		if (L <= mid) {
			for (int i = L; i <= mid; i++) {
				tmp[idx++] = arr[i];
			}
		} else {
			for (int i = R; i <= end; i++) {
				tmp[idx++] = arr[i];
			}
		} // 남은 요소들 정리 완료
		
		// 원본에 덮어버리기
		for (int i = start; i <= end; i++) {
			arr[i] = tmp[i];
		}
	}
    

}
