package chapter8;

import java.util.Scanner;

public class Q5 {
	public static boolean[] prime = new boolean[246913];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		
		getPrime();
		while (true) {
			int n = sc.nextInt();
			if(n==0) break;
			int cnt = 0;
			for (int i = n + 1; i <= 2 * n; i++) {
				if (prime[i] == false) {
					cnt++;
				}
			}

			System.out.println(cnt);
		}
		sc.close();
	}

	public static void getPrime() {

		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i]) continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

	}
}
