package kr.human.lambda;

public class Ex03_lambda03 {
	// 인수도 없고 리턴값도 없다 ==> Runnable을 사용
	public static void main(String[] args) {
		System.out.println("하하하");
		System.out.println("\n"); // 빈줄 2개 출력
		System.out.println("하하하");
		
		// 람다로 표현
		Runnable blankDoubleLine = ()->System.out.println("\n");
		System.out.println("하하하");
		blankDoubleLine.run(); // 빈줄 2개 출력
		System.out.println("하하하");
		
		Runnable line = ()->System.out.println("-".repeat(50));
		System.out.println("하하하");
		line.run(); // 선 그리기
		System.out.println("하하하");
		line.run();
		
	}

}
