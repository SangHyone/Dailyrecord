package chapter4;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		int a, b, c;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();

		int result = a * b * c;

		int ar[] = new int[10];

		while (result > 0) {
			ar[result % 10]++;
			result /= 10;
		}
		for (int i = 0; i < ar.length; i++) {
			System.out.println(ar[i]);
		}

		sc.close();
	}
}