import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		int hour = sc.nextInt();
		int minute = sc.nextInt();
		int time = sc.nextInt();
		
		int overTime = 0;
		int newMinute = minute + time;
		if (newMinute >= 60) {
			overTime  = newMinute / 60;
			newMinute = newMinute % 60;
		}
		
		int newHour = hour + overTime;
		if (newHour >= 24) {
			newHour -= 24;
		}
		
		System.out.println(newHour + " " + newMinute);
		
		sc.close();
 	}

}