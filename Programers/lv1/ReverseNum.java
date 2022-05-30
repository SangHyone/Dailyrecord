package lv1;

public class ReverseNum {
	public static void main(String[] args) {
		
	}
	
	public static int[] solution(long n) {
		String[] ar = String.valueOf(n).split("");
		int[] anwser = new int[ar.length];
		for(int i =anwser.length-1; i>=0; i--) anwser[anwser.length-1-i]=Integer.parseInt(ar[i]);
        return anwser;
    }
}
