package april19;

import java.util.Scanner;

public class Ex08 {
	public static void main(String[] args) {
		int year, month = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("년을 입력하시오(0은 종료)");
			year = sc.nextInt();
			if (year == 0)
				break;
			System.out.println("월을 입력하시오(0은 종료)");
			month = sc.nextInt();

			System.out.printf("\n%16d년 %02d월\n\n", year, month);
			System.out.println("-".repeat(38));
			System.out.println("   일   월   화   수   목   금   토");
			System.out.println("-".repeat(38));

			int w = getWeek(getTotalDay(year, month, 1));

			for (int i = 0; i < w; i++)
				System.out.print("     ");

			for (int i = 1; i <= getLastDay(year, month); i++) {
				System.out.printf("%5d", i);
				if (getWeek(getTotalDay(year, month, i)) == 6)
					System.out.println();

			}
			System.out.println("\n\n");
		}
		sc.close();
	}

	private static int getWeek(int total) {
		return total % 7;
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
