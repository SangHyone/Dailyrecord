package april25;


class Monster{
	int count; //인스턴스 변수 : 객체마다 변수가 생성된다.
	static int scount=0; // 정적변수(클래스변수) : 모든 객체가 공유하는 변수
	
	public Monster() { //생성자
		count++;
		scount++;
	}
	public int getCount() { // 인스턴스 메소드 : 객체변수를 통해서만 접근 가능한 메소드
		return count;
	}
	public static int getScount() { // 정적 메소드 : 객체 생성 없이도 호출 가능한 메소드
									// 클래스 이름으로 접근해야한다. 정적변수만 사용가능하다.
		
		return scount;
	}
	@Override //소명자 : 객체가 소멸시 자동으로 불려지는 메소드
	protected void finalize() throws Throwable {
		count--;
		scount--;
	}
}
public class MonsterEx {
	public static void main(String[] args) {
		
		System.out.println(Monster.getScount() + "마리");
		
		Monster m1 = new Monster();
		Monster m2 = new Monster();
		Monster m3 = new Monster();
		
		System.out.println(m3.getCount() + "마리");
		System.out.println(Monster.getScount() + "마리");
		
	}
}
