package april25;

import kr.human.vo.PersonVO;

public class PersonEx {
	public static void main(String[] args) {
		PersonVO kimc = new PersonVO();
		// 필드에 접근할때는 .(Dot)연산자를 사용한다.
//		kimc.name = "김종서";
//		kimc.age = 33;
//		kimc.gender = true;
		
		kimc.setName("김종서");
		kimc.setAge(10);
		kimc.setGender(true);
		
		System.out.println(kimc.getName() + "(" + kimc.getAge() + "세," + (kimc.isGender() ? "남" : "여") + ")");
		
		System.out.println(kimc);
		System.out.println(kimc.toString());
		
		
		PersonVO leec = new PersonVO("이순신", 31 , true);
		System.out.println(leec);
		
		System.out.println(leec.getClass().getName()+ "@" + Integer.toHexString(leec.hashCode()));
		
		System.gc();
	}
}
