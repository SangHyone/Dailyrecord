package chapter3;

import java.util.Scanner;

public class Q12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {

			int A = sc.nextInt();
			int B = sc.nextInt();

			if (A == 0 && B == 0) {
				sc.close();
				break;
			}
			System.out.println(A + B);
		}
	}
}