package chapter8;

import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		sc.close();
		int a = Math.min(x, w-x);
		int b = Math.min(y, h-y);
		
		System.out.println(Math.min(a, b));
	}
}
