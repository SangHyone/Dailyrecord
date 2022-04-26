package chapter4;

import java.util.Scanner;

public class Q4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] ar = new int[10];
		int result = 0;
		
		for(int i=0; i<ar.length;i++) {
			ar[i] = sc.nextInt()%42;
		}
		sc.close();

		for (int i = 0; i < 10; i++) {
			boolean flag = false;
			for (int j = i + 1; j < 10; j++) {
				if (ar[i] == ar[j]) {
					flag = true;
					break;
				}
			}
			if (flag == false) {
				result++;
			}
		}
		System.out.println(result);
	}
}