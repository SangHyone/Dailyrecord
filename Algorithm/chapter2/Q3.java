package chapter2;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int y = sc.nextInt();
		sc.close();

		System.out.print((y % 4 == 0) ? ((y % 400 == 0) ? "1" : (y % 100 == 0) ? "0" : "1") : "0");
	}
}
