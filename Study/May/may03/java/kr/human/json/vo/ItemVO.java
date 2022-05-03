package kr.human.json.vo;

import java.util.List;

import lombok.Data;
@Data
public class ItemVO {
	private String id;
	private String name;
	private List<History> history;
	
	@Data
	public static class History{
		private String date;
		private String item;
		
	}
}
