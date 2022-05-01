package chapter7;

import java.math.BigInteger;
import java.util.Scanner;

public class Q8 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		BigInteger A = new BigInteger(sc.next());
		BigInteger B = new BigInteger(sc.next());
		sc.close();
		
		A = A.add(B);
		System.out.println(A);
	}
}
