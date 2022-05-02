package kr.human.net1;


import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class GsonEx02 {
	public static void main(String[] args) {
		Gson gson = new Gson();
		try {
			// JSON 객체 만들기
			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("name", "한사람");
			jsonObject.addProperty("age", 33);
			jsonObject.addProperty("gender", true);
			jsonObject.addProperty("height", 178.9);

			System.out.println(jsonObject);
			
			// 저장하기
			FileWriter fw = new FileWriter("src/main/resources/person.json");
			gson.toJson(jsonObject, fw);
			fw.flush();
			fw.close();

		} catch (Exception e) {
		}
	}
}
