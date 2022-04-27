package kr.human.java0427;

import java.util.Calendar;

public class Calender1 {
	public static void main(String[] args) {
		
		Calendar calendar = Calendar.getInstance();

		int yy = calendar.get(Calendar.YEAR);
		int mm = calendar.get(Calendar.MONTH) + 1;

		System.out.printf("\n%16d년 %02d월\n\n", yy, mm);
		System.out.println("-".repeat(38));
		System.out.println("   일   월   화   수   목   금   토");
		System.out.println("-".repeat(38));

		int w = getWeek(getTotalDay(yy, mm, 1));

		for (int i = 0; i < w; i++)
			System.out.print("     ");

		for (int i = 1; i <= getLastDay(yy, mm); i++) {
			System.out.printf("%5d", i);
			if (getWeek(getTotalDay(yy, mm, i)) == 6)
				System.out.println();

		}
		System.out.println("\n\n");
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
