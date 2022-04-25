package kr.human.vo;
// VO(Value Object) : 값을 저장하기 위한 용도의 클래스
// DTO(Data Transfer Object) : 값을 전달하기 위한 용도의 클래스

import java.io.Serializable;
import java.util.Objects;

// 클래스는 사용자 정의 자료형이다. 내가 만드는 새로운 타입니다.
// 캡슐화(묶는다) : 연관성 있는 데이터를 하나로 묶어서 사용한다.
// 값을 저장하는 변수와 그 값을 이용하는 메소드가 합쳐져 있는 것이다. ==> 재사용성이 증가된다.

public class PersonVO implements Serializable{
	
	//변수라고 하지 않고 필드 ,속성, 멤버변수등으로 불린다.
	
	// private 접근 지정자는 클래스 내부에서만 접근 가능하다.
	private String name;
	private int age;
	private boolean gender;
	
	public PersonVO() {
		this("무명", 0, false);
	}
	
	public PersonVO(String name) {
	
		//this.name = name;
		this(name,0,false);
	}
	
	public PersonVO(String name, int age) {
	
		this(name,age,false);
//		this.name = name;
//		this.age = age;
		
	}
	
	public PersonVO(String name, boolean gender) {
		
		this(name, 0, gender);
//		this.name = name;	
//		this.gender = gender;
	}
	
	public PersonVO(String name, int age, boolean gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	@Override // 자바가상머신이 객체들은 구분하기 위해서 분여주는 일련번호이다.
	public int hashCode() {
		return Objects.hash(age, gender, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return age == other.age && gender == other.gender && Objects.equals(name, other.name);
	}
	
	
	
	// 생성자 : 객체 생성시 불려지는 메소드
	//  		클래스와 이름이 같다. 메소드인데 리턴타입이 없다. 오버로딩이 가능하다. 초기화 작업 담당한다.
	//			1개 이상의 생성자를 꼭 가져야한다.
	//			사용자가 생성자를 만들지 않으면 기본 생성자가 자동으로 생성이 된다.
	//			하지만 다른 생성자를 만들면 기본 생성자는 만들어지지 않는다.
	//			기본 생성자란 인수(매개변수)가 없는 생성자이다.
	/*
	public PersonVO() {
		super();
	}
	
	public PersonVO(String name, int age, boolean gender) {
		// 모든 클래스에는 자기 자신을 나타내는 this가 존재한다.
		this.name = name;
		this.age = age;
		this.gender = gender;
		
	}
	
	

	@Override // 오버라이딩 : 이미 존재하는 기능을 재정의해서 사용하는 것
	public String toString() {
		// TODO Auto-generated method stub
		return name + "(" + age + "세," + (gender ? "남" : "여") + ")";
	}*/
}
