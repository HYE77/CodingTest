import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t = 1; t <= 10; t++) { // each test case
			int N = Integer.parseInt(br.readLine()); // 원본 암호문 뭉치 속 암호문의 개수
			st = new StringTokenizer(br.readLine());
			LinkedList pwd = new LinkedList();
			
			// 암호문 뭉치 저장
			for (int i = 0; i < N; i++) {
				pwd.addLast(st.nextToken());
			}
			
			int command = Integer.parseInt(br.readLine()); // 명령문 개수
			
			// 명령문 돌기
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < command; c++) {
				String cmd = st.nextToken();
				switch (cmd) {
				case "I" :
					int x1 = Integer.parseInt(st.nextToken());
					int y1 = Integer.parseInt(st.nextToken());
					
					Node pre = pwd.get(x1);
					Node post = pre.link;
					
					for (int k = 0; k < y1; k++) {
						pre.link = new Node(st.nextToken());
						pre = pre.link;
					}
					
					pre.link = post;
					
					pwd.size += y1;
					break;
					
				case "D" :
					int x2 = Integer.parseInt(st.nextToken());
					int y2 = Integer.parseInt(st.nextToken());
					
					Node pre2 = pwd.get(x2); // 이 다음부터 y2개 삭제
					Node post2 = pre2.link;
					
					for (int k = 0; k < y2; k++) {
						post2 = post2.link;
					}
					
					pre2.link = post2;
					pwd.size -= y2;
					
					break;
					
				case "A" :
					int y3 = Integer.parseInt(st.nextToken()); // y3개 암호를 뒤에 추가
					Node last = pwd.head;
					while (last.link != null) {
						last = last.link;
					}
					
					for (int k = 0; k < y3; k++) {
						last.link = new Node(st.nextToken());
						last = last.link;
					}
					
					pwd.size += y3;
					
					break;
					
					
				}
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			for (int i = 1; i <= 10; i++) {
				String data = pwd.get(i).data;
				sb.append(data).append(" ");
			}
			
			System.out.println(sb);
			
		}
	}
	
	
	static class Node {
		String data;
		Node link;
		
		public Node() {}
		
		public Node(String data) {
			this.data = data;
		}
	}
	
	static class LinkedList {
		Node head;
		int size;
		
		// 노드 삽입 (첫 번째 위치 / 마지막 위치/ 중간 위치)
		public void addFirst(String data) { // Node의 데이터가 String이라서 data도 문자열을 넘기게 만듦. 노드 자체를 파라미터로 만들 수도 있음
			// 1. 노드를 생성
			Node node = new Node(data);
			
			// 2. 노드의 링크는 head를 가리킨다. 
			node.link = head;
			
			// 3. head를 새로 만든 노드로 바꾼다.
			head = node; 
			size++;
			
		}
		
		
		public void addLast(String data) {
			if (size == 0) {
				addFirst(data);
				return;
			}
			
			Node node = new Node(data);
			Node curr = head; // curr = 첫 번째 노드
			while (curr.link != null) {
				curr = curr.link;
			}
			
			curr.link = node;
			size++;

		}
		
		
		public Node get(int idx) {
			if (idx < 0 || idx >= size) {
				return null;
			} 
			Node curr = head;
			for (int i = 0; i < idx; i++) {
				curr = curr.link;
			}
			return curr;
		}
		
		
		public void add (int idx, String data) {
			if (idx == 0) {
				addFirst(data);
			} else if (idx == size) {
				addLast(data);
			} else if (idx < 0 || idx > size) {
				System.out.println("올바른 범위가 아닙니다");
			} else {
				// 중간 위치 삽입!
				Node node = new Node(data);
				
				Node pre = get(idx-1);
				
				node.link = pre.link;
				pre.link = node;
				size++;
			}
		}
		

		
	}
}
