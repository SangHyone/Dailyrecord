package kr.human.io;

import java.io.Serializable;

public class DataVO implements Serializable{
	// 자바는 클래스 내용이 변할때마다 새로운 serialVersionUID를 부여한다.
	// serialVersionUID가 다르면 다른 객체로 인식을 한다. 
	// 그래서 수정 전의 데이터를 읽지 못하는 사태가 발생한다.
	// 이것을 방지하기 위해서는 자동으로 serialVersionUID를 만들어서 serialVersionUID값을 고정시켜 놓으면
	// 된다.
	
	private static final long serialVersionUID = 6629188902613864727L;
	private String stringData;
	private int intData;
	public DataVO(String stringData, int intData) {
		super();
		this.stringData = stringData;
		this.intData = intData;
	}
	@Override
	public String toString() {
		return "DataVO [stringData=" + stringData + ", intData=" + intData + "]";
	}
	public String getStringData() {
		return stringData;
	}
	public void setStringData(String stringData) {
		this.stringData = stringData;
	}
	public int getIntData() {
		return intData;
	}
	public void setIntData(int intData) {
		this.intData = intData;
	}
	
	
}
