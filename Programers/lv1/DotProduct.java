package lv1;

public class DotProduct {
	public static void main(String[] args) {
		
	}
	
	public static int solution(int[] a, int[] b) {
        int answer = 0;
        for(int i=0; i< a.length;i++ ) answer += a[i]*b[i];
        return answer;
    }
}
