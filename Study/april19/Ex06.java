package april19;
import java.util.Scanner;

public class Ex06 {
	public static void main(String[] args) {
		int year, month, day, total =0;
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.println("년을 입력하시오(0은 종료)");
			year = sc.nextInt();
			if(year==0) break;
			System.out.println("월을 입력하시오(0은 종료)");
			month = sc.nextInt();
			System.out.println("일을 입력하시오(0은 종료)");
			day = sc.nextInt();
			
			total = (year-1)*365 +(year-1)/4 -(year-1)/100 + (year-1)/400;
			
			for(int i=1; i<month; i++) total += getLastDay(year,i);
			
			total += day;
			
			System.out.println("총일수 : "+ total + "일");
			switch(total%7){
				case 0: System.out.println("일");break;
				case 1: System.out.println("월");break;
				case 2: System.out.println("화");break;
				case 3: System.out.println("수");break;
				case 4: System.out.println("목");break;
				case 5: System.out.println("금");break;
				case 6: System.out.println("토");break;
			}
		}
		sc.close();
	}
	
	private static int getLastDay(int year, int month) {
		int m[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		m[1] = year%400==0 || year%4==0 && year%100!=0 ? 29 : 28;
		return m[month-1];
	}
}
