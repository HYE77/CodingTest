import java.util.*;
import java.io.*;

public class Main {

    // N개의 주문
    // ti 시간 (편도)
    // ai : irritability
    // hi : 배달 시간(편도)
    // pi : 배달 시간이 i보다 빠른 손님 수
    // si : i 번째 사람 스트레스 (ai x (hi + pi))
    // total stress를 최소화


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // 고객 정보로 배열 만들기
        List<Person> arr = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int irr = Integer.parseInt(st.nextToken());

            arr.add(new Person(time, irr));
        }

        Collections.sort(arr);

        // 시간 구하기
        int currTime = 0;
        long stressSum = 0;

        for (int i = 0; i < arr.size(); i++) {
            Person temp = arr.get(i);
            currTime += temp.time;
            stressSum += (long) temp.irr * (currTime + i);
            currTime += temp.time;

        }

        bw.write(stressSum+"");
        bw.flush();
        bw.close();
        br.close();

    }

}

class Person implements Comparable<Person>{
    int time;
    int irr;

    public Person() {};

    public Person(int time, int irr) {
        this.time = time;
        this.irr = irr;
    }

    @Override
    public int compareTo(Person p) {
        int thisS = this.irr * (p.time * 2 + 1);
        int thatS = p.irr * (this.time * 2 + 1);
        return (int) thatS - thisS;
    }

}