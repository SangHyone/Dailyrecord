package chapter7;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		sc.close();
		
		int cnt = 1, temp = 0;

		while (true) {

			if (X <= temp + cnt) {

				if (cnt % 2 == 1) { 
					
					System.out.print((cnt - (X - temp - 1)) + "/" + (X - temp));
					break;
				}

				else { 
					
					System.out.print((X - temp) + "/" + (cnt - (X - temp - 1)));
					break;
				}

			} else {
				temp += cnt;
				cnt++;
			}
		}
	}
}
