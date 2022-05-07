package chapter9;

import java.util.Scanner;

public class Q5 {

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		sc.close();
		
		sb.append((int) Math.pow(2, n)-1).append('\n');
		
		hanoi(n,1,2,3);
		
		System.out.println(sb);
		
	}

	public static void hanoi(int n, int a, int b, int c) {
		if (n == 1) {
			sb.append(a + " " + c + "\n");
			return;
		}

		hanoi(n - 1, a, c, b);
		
		sb.append(a + " " + c + "\n");
		
		hanoi(n - 1, b, a, c);

	}
}
