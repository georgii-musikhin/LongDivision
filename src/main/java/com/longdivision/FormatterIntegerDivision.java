package com.longdivision;

import java.util.ArrayList;
import java.util.List;

public class FormatterIntegerDivision {
	private String divident;
	private String diviser;
	private String quotient;
	private List<DivisionStep> divisionSteps = new ArrayList<DivisionStep>();
	
	public FormatterIntegerDivision (DivisionModel model) {
		divident = Integer.toString(model.getDivident());
		diviser = Integer.toString(model.getDiviser());
		quotient = Integer.toString(model.getQuotient());
		divisionSteps = model.getDivisionSteps();
	}
	public void printBase() {
		DivisionStep firstStep = divisionSteps.get(0);
		String firstIndent = Integer.toString(firstStep.getIndent());
		String firstMult = Integer.toString(firstStep.getMult());
		String firstStringFormatter = "_%s|%s\n";
		String space = countSpaces((divident.length() + 1), firstIndent.length());
		String nextStringsormatter = " %" + firstIndent.length() + "s%" + space + "s%s%n";
				
		System.out.printf(firstStringFormatter, divident, diviser);
		System.out.printf(nextStringsormatter, firstMult, "|", countLines(quotient));
		System.out.printf(nextStringsormatter,countLines(firstMult), "|", quotient);
		
		if(divisionSteps.size() > 1) {
			printDivision();
		} else {
			String firstRemiinder = Integer.toString(firstStep.getRemainder());
			String secondStringsormatter = " %" + firstIndent.length() + "s";

			System.out.printf(secondStringsormatter, firstRemiinder);
		}
	}

	public void printDivision() {
		for(int i = 1; i < divisionSteps.size(); i++) {
			DivisionStep previousStep = divisionSteps.get(i - 1);
			DivisionStep step = divisionSteps.get(i);
			String prevIndent = Integer.toString(previousStep.getIndent());
			String nextIndent = Integer.toString(step.getIndent());
			String nextMult = Integer.toString(step.getMult());
			String stringFormatter = " %" + (prevIndent.length() + i) + "s%n";

			System.out.printf(stringFormatter, nextIndent);
			System.out.printf(stringFormatter, nextMult);
			System.out.printf(stringFormatter, countLines(nextIndent));
			
			if((i + 1) == divisionSteps.size()) {
				String reminder = Integer.toString(step.getRemainder());

				System.out.printf(stringFormatter, reminder);
			}
		}
	}
	public static String countLines(String s) {
		StringBuilder result = new StringBuilder("");
		
		for(int i = 0; i < s.length(); i++) {
			result.append("-");
		}
		return result.toString();
	}
	public static String countSpaces (int firstString, int secondString) {
		String result = "";
		if(firstString !=  secondString) {
			result = Integer.toString(firstString -  secondString);
		}
		return result;
	}

	public static void main(String[] args) {
		DivisionModel model = new DivisionModel(59678, 600);
		model.fillListOfSteps();
		FormatterIntegerDivision form = new FormatterIntegerDivision(model);
		form.printBase();
	}
}
