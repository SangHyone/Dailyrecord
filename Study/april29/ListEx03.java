package kr.human.java0429;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

// List : 입력 순서가 중요할때 사용하는 자료구조
public class ListEx03 {
	public static void main(String[] args) {
		List<String> v = new ArrayList<>(); // 싱글스레드에만 안전하다.
		// 멀티스레드에서도 사용하려면 어떻게 해야할까요?
		Collections.synchronizedList(v); // 멀티스레드에서 안전하게 작동됨!! ==> 동기화!!!
		
		v.add("한사람");
		v.add("두사람");
		v.add("세사람");
		v.add("네사람");
		v.add("오사람"); // add : 추가
		System.out.println(v.size() + " : " + v); // capacity : 용량, size : 개수
		v.add("세사람");
		v.add("네사람");
		v.add("오사람");
		System.out.println(", " + v.size() + " : " + v);
		v.add("세사람");
		v.add("네사람");
		v.add("오사람");
		System.out.println(", " + v.size() + " : " + v); // 자동으로 용량이 증가

		
		v.set(0, "고친놈");
		 // 수정
		System.out.println(", " + v.size() + " : " + v); // 자동으로 용량이 증가

		System.out.println(v.get(4)); // 가져오기
		

		v.remove(3);
		v.remove("세사람");
		System.out.println( ", " + v.size() + " : " + v); // 자동으로 용량이 증가

		v.add(0, "추가인");
		v.add(5, "추가인2"); // 삽입
		System.out.println(", " + v.size() + " : " + v); // 자동으로 용량이 증가

		// 반복 1
		for (int i = 0; i < v.size(); i++)
			System.out.println(v.get(i));
		System.out.println("-".repeat(50));

		// 반복 2
		for (String s : v)
			System.out.println(s);
		System.out.println("-".repeat(50));

		// 반복 3
		Iterator<String> it = v.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		System.out.println("-".repeat(50));

		
		
		// Iterator, Enumeration : 단방향검색
		// ListIterator : 쌍방향 검색 지원
		
		ListIterator<String> it2 = v.listIterator();
		System.out.println(it2.next());
		System.out.println(it2.next());
		System.out.println(it2.next());
		System.out.println(it2.previous());
		System.out.println(it2.previous());
		System.out.println(it2.previous());
		System.out.println("-".repeat(50));

		v.clear();
		System.out.println(", " + v.size() + " : " + v); // 자동으로 용량이 증가
		
		v.add("줄어들까?");
		System.out.println(", " + v.size() + " : " + v);
		

	}
}
