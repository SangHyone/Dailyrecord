package chapter3;

import java.util.Scanner;

public class Q5 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.close();
		for (int i = 1; i <= n; i++) {
			System.out.println(i);
		}
	}
}