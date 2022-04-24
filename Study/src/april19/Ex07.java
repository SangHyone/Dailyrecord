package april19;
import java.util.Calendar;
import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		int year, month, day, total = 0;
		Scanner sc = new Scanner(System.in);

		Calendar calendar = Calendar.getInstance();

		int yy = calendar.get(Calendar.YEAR);
		int mm = calendar.get(Calendar.MONTH) + 1;
		int dd = calendar.get(Calendar.DAY_OF_MONTH);

		System.out.printf("오늘 : %04d년 %02d월 %02d일\n", yy, mm, dd);

		int cTotal = getTotalDay(yy, mm, dd);

		System.out.println("오늘까지의 총일수 : " + cTotal + "일(" + getWeek(cTotal) + "요일)");

		while (true) {
			System.out.println("출생일의 년을 입력하시오(0은 종료)");
			year = sc.nextInt();
			if (year == 0)
				break;
			System.out.println("출생일의 월을 입력하시오(0은 종료)");
			month = sc.nextInt();
			System.out.println("출생일의 일을 입력하시오(0은 종료)");
			day = sc.nextInt();

			total = getTotalDay(year, month, day);
			System.out.println("총일수 : " + total + "일(" + getWeek(total) + "요일)");

			System.out.println("당신이 살아온 일수는 총 " + (cTotal - total + 1) + "일");
		}
		sc.close();
	}

	private static String getWeek(int total) {
		String result = "";
		switch (total % 7) {
		case 0:
			result = "일";
			break;
		case 1:
			result = "월";
			break;
		case 2:
			result = "화";
			break;
		case 3:
			result = "수";
			break;
		case 4:
			result = "목";
			break;
		case 5:
			result = "금";
			break;
		case 6:
			result = "토";
			break;
		}
		return result;
	}

	private static int getTotalDay(int year, int month, int day) {
		int total;
		total = (year - 1) * 365 + (year - 1) / 4 - (year - 1) / 100 + (year - 1) / 400;

		for (int i = 1; i < month; i++)
			total += getLastDay(year, i);

		total += day;
		return total;
	}

	private static int getLastDay(int year, int month) {
		int m[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		m[1] = year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ? 29 : 28;
		return m[month - 1];
	}
}
