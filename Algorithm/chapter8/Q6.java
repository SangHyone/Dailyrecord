package chapter8;

import java.util.Scanner;

public class Q6 {
	public static boolean[] prime = new boolean[10001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		getPrime();

		for(int i=0; i<T; i++) {
			int n = sc.nextInt()/2;
			int m = 0;
			while(true) {
				if(!prime[n-m] && !prime[n+m]) {
					System.out.println((n-m) + " " + (n+m));
					break;
				}
				m++;
			}
		}

	}

	public static void getPrime() {

		prime[0] = true;
		prime[1] = true;

		for (int i = 2; i <= Math.sqrt(prime.length); i++) {
			if (prime[i])
				continue;
			for (int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}

	}
}
