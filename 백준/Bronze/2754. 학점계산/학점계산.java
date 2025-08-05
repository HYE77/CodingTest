import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String grade = sc.next();
		
		char first = grade.charAt(0);
		
		
		switch (first) {
		case 'A' :
			char second = grade.charAt(1);
			switch (second) {
			case '+' : System.out.println(4.3); break;
			case '0' : System.out.println(4.0); break;
			case '-' : System.out.println(3.7); break;
			} break;
		case 'B' :
			char second1 = grade.charAt(1);
			switch (second1) {
			case '+' : System.out.println(3.3); break;
			case '0' : System.out.println(3.0); break;
			case '-' : System.out.println(2.7); break;
			} break;
		case 'C' :
			char second2 = grade.charAt(1);
			switch (second2) {
			case '+' : System.out.println(2.3); break;
			case '0' : System.out.println(2.0); break;
			case '-' : System.out.println(1.7); break;
			} break;
		case 'D' :
			char second3 = grade.charAt(1);
			switch (second3) {
			case '+' : System.out.println(1.3); break;
			case '0' : System.out.println(1.0); break;
			case '-' : System.out.println(0.7); break;
			} break;
		case 'F' : System.out.println(0.0); break;

		}
		
		sc.close();
	}

}
