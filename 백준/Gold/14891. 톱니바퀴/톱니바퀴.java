import java.util.*;
import java.io.*;

public class Main {
	
	static ArrayList<List<Integer>> qList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		// 초기 톱니바퀴 만들기
		qList = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			char[] input = br.readLine().toCharArray();
			List<Integer> tmpDeq = new ArrayList<>();
			
			for (char c : input) {
				tmpDeq.add(Integer.parseInt(c+""));
			}
			qList.add(tmpDeq);
		}
		
		// 톱니바퀴 돌리기
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) { 
			st = new StringTokenizer(br.readLine());
			int N =  Integer.parseInt(st.nextToken()); // 돌릴 톱니바퀴
			N--; // 0부터 시작하는 인덱스로 바꿔주기
			int dir = Integer.parseInt(st.nextToken()); // 시계? 반시계?
			
			List<int[]> spinList = what2spin(N, dir); // 돌아가는 톱니바퀴와 방향 저장
			
			for (int[] s : spinList) {
				spin(s[0], s[1]);
			}
		}
		
		// 점수 계산
		int score = 0;
		if (qList.get(0).get(0) == 1) score += 1;
		if (qList.get(1).get(0) == 1) score += 2;
		if (qList.get(2).get(0) == 1) score += 4;
		if (qList.get(3).get(0) == 1) score += 8;
		
		bw.write(score+"");
		bw.flush();
		
		br.close();
		bw.close();
		
		
	}
	
	public static List<int[]> what2spin(int N, int dir) {
		// 어떤 톱니바퀴가 어떤 방향으로 회전하는지를 반환하는 메서드
		// 1. 주변 톱니 돌아가는지 여부 확인하기
		// 2. 돌아가는 톱니랑 방향 확인하고 돌리기
		// 3. N번째 톱니도 돌리기 
		ArrayList<int[]> spinList= new ArrayList<>();
		
		spinList.add(new int[] {N, dir}); // 일단 자기 자신은 무조건 돌림
		
		switch(N) {
		case 0: // 1번 톱니를 돌릴 때
			if (qList.get(0).get(2) != qList.get(1).get(6)) {
				spinList.add(new int[] {1, -spinList.get(0)[1]});
				if (qList.get(1).get(2) != qList.get(2).get(6)) {
					spinList.add(new int[] {2, -spinList.get(1)[1]});
					if (qList.get(2).get(2) != qList.get(3).get(6)) {
						spinList.add(new int[] {3, -spinList.get(2)[1]});
					}
				}
			};
			break;
		case 1: // 2번 톱니를 돌릴 때
			if (qList.get(1).get(6) != qList.get(0).get(2)) {
				spinList.add(new int[] {0, -dir});
			}
			if (qList.get(1).get(2) != qList.get(2).get(6)) {
				spinList.add(new int[] {2, -dir});
				if (qList.get(2).get(2) != qList.get(3).get(6)) {
					spinList.add(new int[] {3, dir});
				}
			}
			break;
		case 2: // 3번 톱니를 돌릴 때
			if (qList.get(2).get(2) != qList.get(3).get(6)) {
				spinList.add(new int[] {3, -dir});
			}
			if (qList.get(1).get(2) != qList.get(2).get(6)) {
				spinList.add(new int[] {1, -dir});
				if (qList.get(0).get(2) != qList.get(1).get(6)) {
					spinList.add(new int[] {0, dir});
				}
			}
			break;
		case 3: // 4번 톱니를 돌릴 때
			if (qList.get(3).get(6) != qList.get(2).get(2)) {
				spinList.add(new int[] {2, -spinList.get(0)[1]});
				if (qList.get(2).get(6) != qList.get(1).get(2)) {
					spinList.add(new int[] {1, -spinList.get(1)[1]});
					if (qList.get(1).get(6) != qList.get(0).get(2)) {
						spinList.add(new int[] {0, -spinList.get(2)[1]});
					}
				}
			};
			break;
		}
		
		return spinList;
	}
	
	
	
	public static void spin(int N, int dir) {
		// N번째 톱니바퀴를 dir 방향으로 회전시키는 메서드
		if (dir == 1) {
			// 시계방향으로 돌리기 -> 제일 뒤에 있는 애를 0번 인덱스에 넣기
			int tmp = qList.get(N).get(7);
			qList.get(N).remove(7);
			qList.get(N).add(0, tmp);
		} else {
			// 반시계 방향을 돌리기 -> 제일 앞에 있는 애를 마지막 인덱스에 넣기
			int tmp = qList.get(N).get(0);
			qList.get(N).remove(0);
			qList.get(N).add(7, tmp);
		}
		
	}

}
