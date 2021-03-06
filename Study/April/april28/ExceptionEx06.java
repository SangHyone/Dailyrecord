package kr.human.java0428;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ExceptionEx06 {
	public static void main(String[] args) {
		// 외부 자원에 접근할때는 예외 처리가 필수이다.
		Scanner sc= null;
		try {
			 sc = new Scanner(new URL("https://www.naver.com").openStream());
			 while(sc.hasNextLine()) {
				 System.out.println(sc.nextLine());
			 }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
}
