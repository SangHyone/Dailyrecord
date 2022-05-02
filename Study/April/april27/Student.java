package kr.human.java0427;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends Human{
	private String stuNum;
	
	public Student(String stuNum, String name) {
		super(name); // 이름은 부모에 전달해서 초기화
		this.stuNum = stuNum;
	}
	// 오버라이딩 : 기능 변경
	@Override
	public void think() {
		System.out.println("이번 중간고사를 잘 봐야 할텐데!!!");
	}
	
	// 기능 추가
	public void study() {
		System.out.println("하늘천 땅지 검을현....");
	}
	
	
}
