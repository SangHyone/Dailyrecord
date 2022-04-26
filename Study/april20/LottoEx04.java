package april20;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoEx04 {
	public static void main(String[] args) {
		Random random = new Random();
		Set<Integer> lotto = new HashSet<>();
		while(lotto.size()<6) lotto.add(random.nextInt(45)+1);
		System.out.println("자동 생성 로또번호 : " + lotto);
	
		System.out.println("자동 생성 로또번호 : ");
		random.ints(6,1,45).forEach(System.out::println);
	}
}
