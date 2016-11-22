package com.navercorp.yang.basic.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.ibatis.type.Alias;

/**
 * 사과 정보 객체
 * @author Naver
 *
 */
@Alias("apple")
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
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	public String toStringSimple() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
	}
	
	public String toStringMultiLine() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}