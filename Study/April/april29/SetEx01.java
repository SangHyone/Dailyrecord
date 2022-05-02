package kr.human.java0429;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetEx01 {
	public static void main(String[] args) {
		// Set : 입력순서가 중요하지 않을때 사용한다. 중복을 자동으로 제거해 준다.
		Set<Integer> set = new HashSet<>();
		System.out.println(set.size() + "개 : " + set);

		for (int i = 1; i < 5; i++)
			set.add(i); // 4개 추가
		System.out.println(set.size() + "개 : " + set);

		for (int i = 1; i < 5; i++)
			set.add(i); // 4개 추가
		System.out.println(set.size() + "개 : " + set); // 중복을 허용하지 않는다.

		for (int i = 5; i < 11; i++)
			set.add(i); // 6개 추가
		System.out.println(set.size() + "개 : " + set);

		for (int i : set)
			System.out.println(i);

		System.out.println();

		Iterator<Integer> it = set.iterator(); // 데이터를 반복시켜주는 반복자!!!
		while (it.hasNext())
			System.out.println(it.next());
		
		Set<Integer> lotto = new HashSet<>();
		Random rnd = new Random();
		while(lotto.size()<6) {
			lotto.add(rnd.nextInt(45)+1);
		}
		System.out.println("자동 생성된 로또번호 : " + lotto);
		// TreeSet은 정렬이 지원되는 Set이다.
		Set<Integer> lotto2 = new TreeSet<>();
		while(lotto2.size()<6) {
			lotto2.add(rnd.nextInt(45)+1);
		}
		System.out.println("자동 생성된 로또번호 : " + lotto2);
	}
}
