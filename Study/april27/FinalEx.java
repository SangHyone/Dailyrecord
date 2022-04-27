package kr.human.java0427;

class Some2{
	// 메서드 앞에 final이 붙으면 오버라이딩 금지!!!
	final public void show() {
		System.out.println("나는 오버라이딩할 수 없다!!!");
	}
}

class ChildSome2 extends Some2{
	// 에러다!! 왜? final메서드는 오버라이딩 금지!!
	
}
// 클래스 앞에 final이 붙으면 상속 금지!!
final class FinalClass{
	
}
// 에러다!! final 클래스는 상속 금지!!


public class FinalEx {
	
	// 변수명 앞에 final이 붙으면 변경금지!!!
	static final int MAX = 1024;
	final static int MAX2 = 1024;
	
	public static void main(String[] args) {
		System.out.println("MAX = " + MAX);
		// MAX = 2048; // 에러!! 변경할 수 없다.
	}
}
