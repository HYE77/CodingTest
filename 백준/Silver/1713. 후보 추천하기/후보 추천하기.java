import java.util.*;
import java.io.*;

public class Main {
    static Map<Integer, int[]> students;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 사진틀 개수
        int M = Integer.parseInt(br.readLine()); // 추천 횟수

        students = new HashMap<>(); // 학생 번호 : {표 수, 몇 번째로 등록?}

        int cnt = 0; // 현재 사진틀에 걸려 있는 학생들

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            int std = Integer.parseInt(st.nextToken());

            if (students.containsKey(std)) { // 이미 사진틀에 있는 학생이라면
                students.get(std)[0]++;
                continue;
            }

            // 새 학생일 때
            if (cnt < N) { // 자리가 있다면
                students.put(std, new int[]{1, i});
                cnt++;
            } else {
                findDelete(); // 삭제
                students.put(std, new int[]{1, i});
            }

        }

        // 득표자 순으로 출력
        ArrayList<int[]> voted = new ArrayList<>();
        for (int std : students.keySet()) {
            if (students.get(std)[0] > 0) { // 득표를 했다면
                int tmp = students.get(std)[0];
                voted.add(new int[] {std, tmp});
            }
        }

        Collections.sort(voted, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] a : voted) {
            bw.write(a[0]+ " ");
        }


        bw.flush();
        br.close();
        bw.close();
    }

    static  void findDelete() {
        int std2Delete = -1; // 사진틀에서 내려올 학생 번호
        int min = Integer.MAX_VALUE; // 가장 작은 투표값
        int minOrder = -1; // 가장 작은 값을 가진 애가 언제 입후보?

        for (int std : students.keySet()) {
            if (students.get(std)[0] > 0 && students.get(std)[0] < min) {
                std2Delete = std;
                min = students.get(std)[0];
                minOrder = students.get(std)[1];
            } else if (students.get(std)[0] > 0 && students.get(std)[0] == min) {
                // 같은 최소 표수 가진 학생이 있는 경우, 더 오래된 학생 지워야 함
                if  (students.get(std)[1] < minOrder) {
                    // 이 학생이 더 전에 들어왔으면 -> 갱신
                    std2Delete = std;
                    minOrder = students.get(std)[1];

                }
            }
        }

        students.remove(std2Delete);
    }



}
