package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileIOEx02 {
	public static void main(String[] args) {
		// 최근 방식 : 자동 닫기
		
		try(FileInputStream fis = new FileInputStream("src/main/resources/chunja2.txt");) {
			
			int n = 0;
			while((n=fis.read())>0) { // read() : 1Byte읽는다. 리턴 타입 int타입. 없으면 -1 리턴
				System.out.println((char)n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} 
	}
}
