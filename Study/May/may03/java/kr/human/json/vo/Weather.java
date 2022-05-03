package kr.human.json.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlRootElement(name="rss")
public class Weather {
	private Channel channel;
	@Data
	@XmlRootElement
	@XmlType(propOrder = {"title","link","description","generator","pubDate","item"})
	public static class Channel{
		private String title;
		private String link;
		private String description;
		private String generator;
		private String pubDate;
		private List<Item> item;
	}
	@Data
	@XmlRootElement
	public static class Item{
		private String author;
		private String category;
		private String title;
	}
}
