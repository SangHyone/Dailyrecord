package kr.human.java0428;

class Some{
	
	private String name;
	private int age;
	
	
	public Some() {
		super();
	}


	public Some(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + age;
	}

	// 내용이 같으면 같은 객체로 판단하고 싶다. 그런 경우는 반드시 equals메서드를 오버라이딩 해줘야한다.
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}




	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	
	
}





public class ObjectEx {
	public static void main(String[] args) {
		Some some1 = new Some("한사람", 22);
		System.out.println(some1);
		
		Some some2 = new Some("한사람", 22);
		System.out.println(some2);
		
		System.out.println(some1==some2 ? "같은사람" : "다른사람");
		System.out.println(some1.equals(some2) ? "같은사람" : "다른사람");
		// 해시코드는 JVM이 객체를 구분하기 위해서 붙이는 번호
		System.out.println(some1.hashCode());
		System.out.println(some2.hashCode());
	}
}
