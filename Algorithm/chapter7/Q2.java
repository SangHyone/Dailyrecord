package chapter7;

import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		sc.close();

		int cnt = 1;
		int t = 2;

		if (N == 1) {
			System.out.println(1);
		} else {
			while (t <= N) {
				t += (6 * cnt);
				cnt++;
			}
			System.out.println(cnt);
		}
	}
}
