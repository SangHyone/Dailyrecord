package kr.human.service;

public class InsertService {
	public static int insert(String data) {
		int result = 0;
		try {
			// DAO를 호출해서 저장을 수행한다.
			result = 1;
		}catch (Exception e) {
			result = 0;
		} finally {
			
		}
		return result;
	}
}
