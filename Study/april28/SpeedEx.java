package kr.human.java0428;

public class SpeedEx {
	public static void main(String[] args) {
		String str = "";
		StringBuffer sBuffer = new StringBuffer();
		StringBuilder sBuilder = new StringBuilder();
		
		long start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) { // "꽝"을 붙여서 10000개를 만들어 보자
			str += "꽝";
		}
		System.out.println("실행시간 : " + (System.currentTimeMillis()-start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) { // "꽝"을 붙여서 10000개를 만들어 보자
			sBuffer.append("꽝");
		}
		System.out.println("실행시간 : " + (System.currentTimeMillis()-start) + "ms");
		
		start = System.currentTimeMillis();
		for(int i=0;i<10000;i++) { // "꽝"을 붙여서 10000개를 만들어 보자
			sBuilder.append("꽝");
		}
		System.out.println("실행시간 : " + (System.currentTimeMillis()-start) + "ms");
	}
}
