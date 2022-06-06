package lv1;

public class FillInTheInsufficientAmount {
	public static void main(String[] args) {
		
	}
	
	public static long solution(int price, long money, int count) {
        long answer = 0;
        for(int i=1; i<=count; i++){
            money-=price*i;
        }
        if(money<0){
            answer = money*(-1);
        }
        return answer;
    }
}
