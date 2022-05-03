package chapter8;

import java.util.Scanner;

public class Q8 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x1 = sc.nextInt(), y1 = sc.nextInt();
		int x2 = sc.nextInt(), y2 = sc.nextInt();
		int x3 = sc.nextInt(), y3 = sc.nextInt();

		sc.close();
		int x4 = x1;
		int y4 = y1;
		if (x1 == x2) {
			x4 = x3;
		} else if (x1 == x3) {
			x4 = x2;
		}

		if (y1 == y2) {
			y4 = y3;
		} else if (y1 == y3) {
			y4 = y2;
		}

		System.out.println(x4 + " " + y4);

	}
}
