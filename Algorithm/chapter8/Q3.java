package chapter8;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		sc.close();
		for(int i=2; i<=N; i++) {
			while(N%i==0) {
				System.out.println(i);
				N = N/i;
			}
		}
		if(N != 1) {
			System.out.println(N);
		}
	}
}
