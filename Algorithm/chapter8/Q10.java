package chapter8;

import java.util.Scanner;

public class Q10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double R = sc.nextDouble();
		sc.close();
		System.out.println(R * R * Math.PI);
		System.out.println(R * R * 2);
	}
}
