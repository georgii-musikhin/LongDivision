package com.longdivision;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DivisionModel {
	
	private int divident;
	private int diviser;
	private int quotient;
	private List<DivisionStep> divisionSteps = new ArrayList<DivisionStep>();
	
	public DivisionModel(int divident, int diviser) {
		if(diviser == 0) {
			throw new ArithmeticException("You cannot divide by zero!");
		}
		this.divident = divident;
		this.diviser = diviser;
		this.quotient = divident / diviser;
	}
	
	public void fillListOfSteps() {
		Stack<Integer> splittedByDigits = splitNumberByDigits(divident);
		 
		while(!splittedByDigits.isEmpty()) {
			divisionSteps.add(new DivisionStep(splittedByDigits, diviser));
		}
	}
	public static Stack<Integer> splitNumberByDigits(int number) {  
		Stack<Integer> result = new Stack<Integer>();

		while (number >= 1) {
			result.push(number % 10);
			number /= 10;
		}
		return result;
	}
	public int getDivident() {
		return divident;
	}

	public int getDiviser() {
		return diviser;
	}

	public int getQuotient() {
		return quotient;
	}

	public List<DivisionStep> getDivisionSteps() {
		return divisionSteps;
	}
}
