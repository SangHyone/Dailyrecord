package kr.human.java0427;

public class Var2 {
	Var var = new Var();
	
	public void view() {
		// 에러다!!! private 멤버는 그 클래스 내부에서만 사용가능하다.
		// System.out.println("private 변수 : " + var.priValue);
		System.out.println("default 변수 : " + var.defValue); // default는 같은 패키지 내에서는 사용가능
		System.out.println("protected 변수 : " + var.proValue);
		System.out.println("public 변수 : " + var.pubValue);
	}
}
