package kr.human.java0428;

import java.util.Scanner;

public class ExceptionEx02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x=0,y=0;
		System.out.println("두개의 정수 입력 : ");
		
		String temp = sc.next();
		if(temp!=null && !temp.equals("")) { // 입력이 되었다면
			for(char ch : temp.toCharArray()) {
				if(ch<'0' || ch>'9') {
					System.out.println("숫자만 입력하세요!!!");
					System.exit(0);
				}
			}
			x = Integer.parseInt(temp);
		}
		
		temp = sc.next();
		if(temp!=null && !temp.equals("")) { // 입력이 되었다면
			for(char ch : temp.toCharArray()) {
				if(ch<'0' || ch>'9') {
					System.out.println("숫자만 입력하세요!!!");
					System.exit(0);
				}
			}
			y = Integer.parseInt(temp);
		}
		
		
		if(y==0) {
			System.out.println("0으로 나눌 수 없어요!!!");
		}else {
			int result = x/y;
			System.out.println(x + "/" + y + "=" + result);
		}
		

		sc.close();
	}
}
