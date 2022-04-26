package chapter6;

import java.util.Scanner;

public class Q7 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		sc.close();
		
		A = (A%10)*100 + ((A%100)/10)*10 + A/100; 
		B = (B%10)*100 + ((B%100)/10)*10 + B/100; 
		
		System.out.println(A>B ? A : B);
	}
}
