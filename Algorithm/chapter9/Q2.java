package chapter9;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(getNum(N));
		sc.close();
	}

	public static int getNum(int n) {
		if (n >= 2) {
			n = getNum(n - 1) + getNum(n - 2);
		} else if (n < 2) {

		}
		return n;
	}
}
