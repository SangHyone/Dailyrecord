package april22;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class TestEx01 {
	
	public static int add(int a, int b) {
		return a+b;
	}
	
	@Test
	public void addTest() {
		assertEquals(add(2,3),5);
		assertNotEquals(add(2,3), 5);
	}
}
