package chapter7;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long A = sc.nextInt();
		long B = sc.nextInt();
		long V = sc.nextInt();
		sc.close();
		long cnt = (V - B) / (A - B);

		if ((V - B) % (A - B) != 0) {
			cnt++;
		}

		System.out.println(cnt);
	}
}
