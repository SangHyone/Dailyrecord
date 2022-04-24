package april19;
import java.util.Scanner;

public class Ex05 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score;
		
		do {
			System.out.println("점수 입력 : ");
			score = sc.nextInt();
		}while(score<0 || score>100);
		
		String grade = "F";
		
		if(score>=90) grade = "A";
		else if(score>=80) grade = "B";
		else if(score>=70) grade = "C";
		else if(score>=60) grade = "D";
		
		System.out.println(score + "의 학점은 \"" + grade + "\"입니다.");

		
		sc.close();
	}
}
