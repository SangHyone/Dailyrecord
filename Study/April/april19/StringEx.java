package april19;

public class StringEx {
	public static void main(String[] args) {
		String name1 = "한사람";
		String name2 = "한사람"; //""로 초기화를 하면 이미 만들어진 한사람의 위치를 공유한다.
		String name3 = new String("한사람"); //new를 사용하면 항상 새로운 메모리를 확보하여 그 주소를 참조한다.
		String name4 = new String("한사람");
		
		System.out.println(name1);
		System.out.println(name2);
		System.out.println(name3);
		System.out.println(name4);
		System.out.println();
		
		// ==로 비교하면 주소로 비교를 한다.
		System.out.println(name1==name2 ? "같은 사람":"다른 사람" );
		System.out.println(name1==name3 ? "같은 사람":"다른 사람" );
		System.out.println(name3==name4 ? "같은 사람":"다른 사람" );
		System.out.println();
		
		// 문자열의 내용을 비교하려면 반드시 equals 매소드로 비교해야 한다. 
		System.out.println(name1.equals(name2) ? "같은 사람":"다른 사람" );
		System.out.println(name1.equals(name3) ? "같은 사람":"다른 사람" );
		System.out.println(name3.equals(name4) ? "같은 사람":"다른 사람" );
		
		System.out.println(Math.PI);
	}
	
}
