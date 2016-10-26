package com.navercorp.yang.chapter.com;

/**
 * 사과 정보 객체
 * @author Naver
 *
 */
public class Apple {
	private String color;
	private int weight;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public boolean isGreenApple() {
		return "green".equals(getColor());
	}
	
	public boolean isHeavyApple() {
		return 150 < getWeight();
	}
}