package april19;

public class LeapYearEx {
	public static void main(String[] args) {
		System.out.println(isLeapYear1(4) ? "윤" : "평");
		System.out.println(isLeapYear1(100) ? "윤" : "평");
		System.out.println(isLeapYear1(400) ? "윤" : "평");
		System.out.println();
		System.out.println(isLeapYear2(4) ? "윤" : "평");
		System.out.println(isLeapYear2(100) ? "윤" : "평");
		System.out.println(isLeapYear2(400) ? "윤" : "평");
	}
	
	private static boolean isLeapYear1(int year) {
		boolean result = false;
		if(year%4==0) {
			if(year%100!=0) {
				result = true;
			}else {
				if(year%400==0) {
					result = true;
				}else {
				result = false;
				}
			}
		}
		return result;
	}
	
	private static boolean isLeapYear2(int year) {
		return year%400==0 || year%4==0 && year%100!=0;
	}
}