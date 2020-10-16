package com.longdivision;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DivisionModel {
	
	private int divident;
	private int diviser;
	private int quotient;
	private List<DivisionStep> divisionSteps;
	
	public DivisionModel(int divident, int diviser) {
		checkArguments(divident, diviser);
		
		this.divident = divident;
		this.diviser = diviser;
		this.quotient = divident / diviser;
		this.divisionSteps = new ArrayList<DivisionStep>();
		this.divisionSteps = fillListOfSteps(divident, diviser);
	}
	
	public static ArrayList<DivisionStep> fillListOfSteps(int divident, int diviser) {
		ArrayList<DivisionStep> result = new ArrayList<DivisionStep>();
		Stack<Integer> splittedByDigits = splitNumberByDigits(divident);
		 
		while(!splittedByDigits.isEmpty()) {
			result.add(new DivisionStep(splittedByDigits, diviser));
		}
		return result;
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
	
	private static void checkArguments(int divident, int diviser) {
		if((divident < 0) || (diviser < 0)) {
			throw new IllegalArgumentException("Arguments must be positive");
		}
		if(diviser == 0) {
			throw new IllegalArgumentException("You cannot divide by zero");
		}
		if(diviser > divident) {
			throw new IllegalArgumentException("Dividend must be greater than or equal to the quotient");
		}
	}
	public static void main(String[] args) {
		DivisionModel model = new DivisionModel(2005002, 2);
	}
}
