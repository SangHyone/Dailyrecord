package lv1;

public class Lv1Keypad {
	public static void main(String[] args) {
		
	}
	
	public static String solution(int[] numbers, String hand) {
		StringBuilder sb = new StringBuilder();
		int left=10, right=12;
		int LD, RD;
		for(int i : numbers) {
			LD = 0; RD = 0;
			if(i == 1 || i == 4 || i == 7) {
				sb.append("L");
				left = i;
			
			}else if(i == 3 || i == 6 || i == 9) {
				sb.append("R");
				right = i;
			
			}else {
				if(i==0) i += 11;
				LD = (Math.abs(i-left))/3 + (Math.abs(i-left))%3;
				RD = (Math.abs(right-i))/3 + (Math.abs(right-i))%3;
				if(LD == RD) {
					if(hand.equals("right")) {
						sb.append("R");
						right = i;
					}else {
						sb.append("L");
						left = i;
					}
				}else if(LD > RD) {
					sb.append("R");
					right = i;
				}else {
					sb.append("L");
					left = i;
				}
			}
		}
		
		
		
		return sb.toString();
	}
}
