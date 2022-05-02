package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataLoad {
	public static void main(String[] args) {
		// 객체가 저장될때는 인스턴스 변수만 저장된다.
		// static변수나 메서드는 저장되지 않는다. 모든 객체가 공유하므로 저장할 필요가없다.
		DataVO vo = null;
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data3.dat"))) {
			System.out.println(ois.readObject()); // 읽어서 출력
			System.out.println("읽기완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
