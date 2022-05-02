package kr.human.java0502;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

// Properties : <String, String>인 맵이다.
public class PropertiesEx01 {
	public static void main(String[] args) {
		Properties properties = new Properties();
		// 추가
		properties.setProperty("db", "Oracle");
		properties.setProperty("dbuser", "system");
		properties.setProperty("dbpassword", "system123");
		// 읽기
		System.out.println(properties.getProperty("db"));
		System.out.println(properties.getProperty("dbuser"));
		System.out.println(properties.getProperty("dbpassword"));
		// 파일로 저장하기
		try {
			properties.store(new FileWriter("db.properties"), "데이터베이스 사용자 정보");
			properties.storeToXML(new FileOutputStream("db.xml"), "데이터베이스 사용자 정보");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
