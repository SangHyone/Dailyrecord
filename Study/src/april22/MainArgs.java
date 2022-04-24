package april22;

public class MainArgs {
	public static void main(String[] args) {
		//명령행 파라메터를 사용해보자
		System.out.println("인수의 개수 : " + args.length + "개");
		if(args.length>0) {
			for(String param : args) {
				System.out.println(param);
			}
		}else {
			System.out.println("인수 없다.");
		}
	}
}
