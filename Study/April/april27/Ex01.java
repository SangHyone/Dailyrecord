package kr.human.java0427;

class Parent {
	public Parent() {
		System.out.println("Parent 생성자 호출");
	}
	
}

class Child extends Parent {	// Parent 클래스를 상속받아 Child클래스를 만든다.
	public Child() {
		System.out.println("Child 생성자 호출");
	}
}

class GrandChild extends Child {
	public GrandChild() {
		super(); // 이 자리에 이 코드가 자동으로 삽입이 된다. 
		System.out.println("GrandChild 생성자 호출");
	}
}

class Some{
	int value;
	public Some(int value) {
		this.value = value;
	}
}

class SomeChild extends Some{
	public SomeChild() {
		// super(); // 자동 삽입이 된다. 그런데 부모 클래스에 ()인 기본 생성자가 없어서 에러이다.
		// 이떄 에러를 방지하려면 명시적으로 부모의 생성자를 직접 호출해주면 된다.
		super(0);
	}
}

class Name{
	String name;
	
	public Name(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name.toUpperCase();
	}
}

class NameChild extends Name{
	int age;
	public NameChild(String name,int age) {
		super(name);
		this.age = age;
	}
	@Override
	public String toString() {
		return super.toString() + "(" + age + "세)";
	}
	
	
}
// 하나의 파일에 클래스를 여러개 만들경우 파일이름과 같은 클래스에만 public을 쓸 수 있다.
public class Ex01 {
	public static void main(String[] args) {
		// 상속받은 클래스의 객체를 만들면 부모 클래스의 생성자부터 차례대로 호출이 된다.
		GrandChild grandChild = new GrandChild();
		
		NameChild nameChild = new NameChild("kimc", 33);
		System.out.println(nameChild.toString());
	}
}











