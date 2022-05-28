package lv1;

public class EvenOdd {
	public static void main(String[] args) {
		
	}
	
	public static String solution(int num) {
        String answer = "";
        if(num%2==0){
            answer="Even";
        }else{
            answer="Odd";
        }
        return answer;
    }
}
