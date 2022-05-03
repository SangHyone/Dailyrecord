package kr.human.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.human.json.vo.ItemVO;

public class Ex09_JsonFileRead {
	public static void main(String[] args) {
		Gson gson = new Gson();
		
		try(FileReader fr = new FileReader("src/main/resources/json.json")){
			ItemVO vo = gson.fromJson(fr, ItemVO.class);
			System.out.println(vo.getId());
			System.out.println(vo.getName());
			for(ItemVO.History h : vo.getHistory()) {
				System.out.println(h.getItem() + " : " + h.getDate());
			}
			
			JsonObject jsonObject = gson.fromJson(fr, JsonObject.class);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
