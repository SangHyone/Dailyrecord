package kr.human.MavenEx;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Person {
	private String name;
	private int age;
	private boolean gender;

	// 복사 생성자 : 자신의 타입을 받는 생성자 ==> 깊은 복사
	public Person(Person person) {
		this.name = person.getName();
		this.age = person.getAge();
		this.gender = person.isGender();
	}

}
