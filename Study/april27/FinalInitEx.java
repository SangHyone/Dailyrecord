package kr.human.java0427;

// 상수성을 가지면서 객체마다 다른 상수를 가지고 싶은 경우 사용한다.
class FinalMemeber{
	final double PI; // final이면 상수인데(변경금지인데) 초기값을 주지 않았다.
	
	// 초기값이 없는 상수 멤버를 가지는 클래스는 반드시 상수를 초기화할 수 있는 생성자를 가져야한다.
	public FinalMemeber(double pi) {
		PI = pi;
	}
}


public class FinalInitEx {
	public static void main(String[] args) {
		FinalMemeber fm1 = new FinalMemeber(3.14);
		System.out.println(fm1.PI);
		
		FinalMemeber fm2 = new FinalMemeber(3.1415);
		System.out.println(fm2.PI);
		
		FinalMemeber fm3 = new FinalMemeber(3.141592);
		System.out.println(fm3.PI);
		
		//fm3.PI = 3.141; // 변경은 못한다. 
	}
}
