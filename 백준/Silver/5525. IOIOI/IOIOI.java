import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int ans = 0;
        int count = 0; // 연속된 "IOI" 개수 저장 -> 이랑 같으면  ans+1

        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                count++;
                if (count == N) { // IOI가 N번 연속 등장
                    ans++;
                    count--; // 다음 IOI도 이어질 수 있으므로 하나 빼줌
                }
                i++; // O로 시작하는 부분 검사 불필요 -> 다음 인덱스 건너뛰자
            } else {
                count = 0; // 끊기면 초기화
            }
        }

        bw.write(ans + "");
        bw.flush();
        br.close();
        bw.close();
    }
}
