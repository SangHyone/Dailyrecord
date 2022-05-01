package chapter8;

import java.util.Scanner;

public class Q2 {
	
	public static boolean prime[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();
		
		sc.close();
		
		prime = new boolean[N + 1];
		getPrime();

		int sum = 0;
		int min = Integer.MAX_VALUE;
		for (int i = M; i <= N; i++) {
			if (prime[i] == false) { 
				sum += i;
				if (min == Integer.MAX_VALUE) { 
					min = i;
				}
			}
		}

		if (sum == 0) { 
			System.out.println(-1);
		} else {
			System.out.println(sum);
			System.out.println(min);
		}

	}
	
	public static void getPrime() {
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
		
	}
}
