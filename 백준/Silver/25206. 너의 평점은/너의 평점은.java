import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double totalCredit = 0;
        double totalGrade = 0;

        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            st = new StringTokenizer(line);
            String subject = st.nextToken();
            double credit = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            char[] gradeArr = grade.toCharArray();
            double tmp = 0;
            switch (gradeArr[0]) {
                case 'A' : tmp = 4.0; break;
                case 'B' : tmp = 3.0; break;
                case 'C' : tmp = 2.0; break;
                case 'D' : tmp = 1.0; break;
                case 'F' : tmp = 0.0; break;
            }

            if (gradeArr.length == 2 && gradeArr[1] == '+') {
                tmp += 0.5;
            }

            if (gradeArr[0] != 'P') {
                totalCredit += credit;
                totalGrade += tmp * credit;
            }

        }

        System.out.println(totalGrade / totalCredit);
        br.close();

    }
}
