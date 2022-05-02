package kr.human.java0427;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test.None;

class NOnSingleton{
	
}

// 싱글톤 패턴 : 프로그램 실행중에 객체를 유일하게 1개만 만들어 재사용할 수 있도록 하는 디자인패턴
class Singleton{
	// 1. 자기 자신의 객체를 정적멤버로 만든다.
	private static Singleton instance = new Singleton();
	
	// 2. 밖에서 객체를 생성하지 못하도록 생성자를 private으로 만든다.
	private Singleton() {
		
	}
	// 3. 만들어진 객체를 리턴하는 정적메서드를 만든다.
	public static Singleton getInstance() {
		return instance;
	}
	
}
public class SingletinoEx {
	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		Singleton singleton2 = Singleton.getInstance();
		Singleton singleton3 = Singleton.getInstance();
		// 자바 가상머신(JVM)이 객체를 구분하기 위해 붙이는 일련번호를 해시코드(hashCode)라고 한다.
		System.out.println(singleton1.hashCode());
		System.out.println(singleton2.hashCode());
		System.out.println(singleton3.hashCode()); // hashCode가 같다면 같은 객체다!!!
		
		NOnSingleton ns1 = new NOnSingleton();
		NOnSingleton ns2 = new NOnSingleton();
		
		System.out.println(ns1.hashCode());
		System.out.println(ns2.hashCode()); // hashCode가 다르다. 객체가 여러개다!!
		
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
	}
}
