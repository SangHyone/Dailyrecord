package kr.human.lunar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

public class PollUtil {
	// 투표하기 파일을 읽어서 리턴하기
	public static PollVO readPoll(String filename) {
		PollVO pollVO = null;
		
		try(FileReader fr = new FileReader(filename)){
			Gson gson = new Gson();
			pollVO = gson.fromJson(fr, PollVO.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pollVO;
	}
	
	// 투표하기 파일을 저장하기
		public static void savePoll(String filename, PollVO pollVO) {
			
			try(PrintWriter pw = new PrintWriter(filename)){
				Gson gson = new Gson();
				gson.toJson(pollVO, pw);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
}
