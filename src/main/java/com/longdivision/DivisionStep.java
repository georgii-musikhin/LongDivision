package com.longdivision;

import java.util.Stack;

public class DivisionStep {
	private int dividend = 0;
	private int result = 0;
	private int mult = 0;
	private int remainder = 0;
	private static int indentCount = 0;
	private int indent = 0;
	
	public DivisionStep(Stack<Integer> splittedByDigits, int diviser) {
		
		dividend = splittedByDigits.pop();
		indentCount++;
		while ((dividend < diviser) && (!splittedByDigits.isEmpty()))  {
			dividend = (dividend * 10) + splittedByDigits.pop();
			indentCount++;
		}
		result = dividend / diviser;
		mult = diviser * result;
		remainder = dividend - mult;
		indent = indentCount;
		if (!splittedByDigits.isEmpty()) {
			splittedByDigits.push(remainder);
			indentCount--;
		}
	}

	public int getDividend() {
		return dividend;
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

	public int getIndent() {
		return indent;
	} 
}
