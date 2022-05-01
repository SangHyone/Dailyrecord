package chapter8;

import java.util.Scanner;

public class Q1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int cnt = 0;

		for (int i = 0; i < N; i++) {

			boolean prime = true;

			int num = sc.nextInt();

			if (num == 1) { 
				continue;
			}
			for (int j = 2; j <= Math.sqrt(num); j++) {
				if (num % j == 0) {
					prime = false; 
					break;
				}
			}
			if (prime) { 
				cnt++;
			}
		}
		sc.close();
		System.out.println(cnt);
	}
}
