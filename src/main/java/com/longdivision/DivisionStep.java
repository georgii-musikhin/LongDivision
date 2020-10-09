package com.longdivision;

import java.util.Stack;

public class DivisionStep {
	private int indent = 0;
	private int result = 0;
	private int mult = 0;
	private int remainder = 0;
	
	public DivisionStep(Stack<Integer> splittedByDigits, int diviser) {
		 
		while ((indent < diviser) && (!splittedByDigits.isEmpty()))  {
			indent = (indent * 10) + splittedByDigits.pop();
		}
		result = indent / diviser;
		mult = diviser * result;
		remainder = indent - mult;
		if (!splittedByDigits.isEmpty()) {
			splittedByDigits.push(remainder);
		}
	}

	public int getIndent() {
		return indent;
	}

	public int getResult() {
		return result;
	}

	public int getMult() {
		return mult;
	}

	public int getRemainder() {
		return remainder;
	} 
	
	
}
