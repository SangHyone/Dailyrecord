package lv1;

public class HidePhoneNum {
	public static void main(String[] args) {
		
	}
	
	public static String solution(String phone_number) {
        String answer = "";
        for(int i = 0 ; i<phone_number.length() ; i++){
            if(phone_number.length() - i <= 4){
                answer += phone_number.charAt(i);
            }else{
                answer += "*";
            }
            
        }
        return answer;
    }
}
