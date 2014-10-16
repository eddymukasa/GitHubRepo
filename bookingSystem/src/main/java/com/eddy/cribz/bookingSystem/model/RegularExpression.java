package com.eddy.cribz.bookingSystem.model;

import java.io.Serializable;

public class RegularExpression implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 856863617740172163L;
	private boolean length;
	private int lowerThreshold;
	private int upperThreshold;
	private boolean oneUpperAlphabet;
	private boolean oneNumericValue;
	private boolean onelowerAlphabet;
	private boolean oneSpecialChar;
	public RegularExpression() {
		super();
	}
	public RegularExpression(boolean length, boolean oneUpperAlphabet,
			boolean oneNumericValue, boolean onelowerAlphabet,
			boolean oneSpecialChar) {
		super();
		this.length = length;
		this.oneUpperAlphabet = oneUpperAlphabet;
		this.oneNumericValue = oneNumericValue;
		this.onelowerAlphabet = onelowerAlphabet;
		this.oneSpecialChar = oneSpecialChar;
	}
	public boolean isLength() {
		return length;
	}
	public void setLength(boolean length) {
		this.length = length;
	}
	public boolean isOneUpperAlphabet() {
		return oneUpperAlphabet;
	}
	public void setOneUpperAlphabet(boolean oneUpperAlphabet) {
		this.oneUpperAlphabet = oneUpperAlphabet;
	}
	public boolean isOneNumericValue() {
		return oneNumericValue;
	}
	public void setOneNumericValue(boolean oneNumericValue) {
		this.oneNumericValue = oneNumericValue;
	}
	public boolean isOnelowerAlphabet() {
		return onelowerAlphabet;
	}
	public void setOnelowerAlphabet(boolean onelowerAlphabet) {
		this.onelowerAlphabet = onelowerAlphabet;
	}
	public boolean isOneSpecialChar() {
		return oneSpecialChar;
	}
	public void setOneSpecialChar(boolean oneSpecialChar) {
		this.oneSpecialChar = oneSpecialChar;
	}
	public int getLowerThreshold() {
		return lowerThreshold;
	}
	public void setLowerThreshold(int lowerThreshold) {
		this.lowerThreshold = lowerThreshold;
	}
	public int getUpperThreshold() {
		return upperThreshold;
	}
	public void setUpperThreshold(int upperThreshold) {
		this.upperThreshold = upperThreshold;
	}
	
	
	
}
