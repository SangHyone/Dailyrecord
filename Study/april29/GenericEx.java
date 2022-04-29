package kr.human.java0429;

public class GenericEx {
	public static void main(String[] args) {
		Box<Integer> intBox = new Box<Integer>();
		intBox.setItem(123);
		int i = intBox.getItem();
		
		
		Box<Double> doubleBox = new Box<Double>();
		doubleBox.setItem(3.14);
		double d = doubleBox.getItem();
		
		Box<String> stringBox = new Box<String>();
		
		
	}
}
