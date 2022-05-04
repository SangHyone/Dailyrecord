package chapter9;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		System.out.println(getNum(N));
		sc.close();
	}

	public static int getNum(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n *= getNum(n - 1);
		}
	}
}
