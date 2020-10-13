package com.longdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionPrinter {
	private String divident;
	private String diviser;
	private String quotient;
	private List<DivisionStep> divisionSteps = new ArrayList<DivisionStep>();

	public DivisionPrinter(DivisionModel model) {
		divident = Integer.toString(model.getDivident());
		diviser = Integer.toString(model.getDiviser());
		quotient = Integer.toString(model.getQuotient());
		divisionSteps = model.getDivisionSteps();
	}

	public void printBase() {
		DivisionStep firstStep = divisionSteps.get(0);
		String firstDiv = Integer.toString(firstStep.getDividend());
		String firstMult = Integer.toString(firstStep.getMult());
		String firstStringFormatter = "_%s|%s\n";
		String space = countSpaces((divident.length() + 1), firstDiv.length());
		String nextStringsormatter = " %s%" + space + "s%s%n";

		System.out.printf(firstStringFormatter, divident, diviser);
		System.out.printf(nextStringsormatter, firstMult, "|", countLines(quotient));
		System.out.printf(nextStringsormatter, countLines(firstMult), "|", quotient);

		if (divisionSteps.size() > 1) {
			printDivision();
		} else {
			String firstRemiinder = Integer.toString(firstStep.getRemainder());
			String secondStringsormatter = " %" + firstDiv.length() + "s";

			System.out.printf(secondStringsormatter, firstRemiinder);
		}
	}

	public void printDivision() {
		for (int i = 1; i < divisionSteps.size(); i++) {
			DivisionStep step = divisionSteps.get(i);
			String nextDiv = Integer.toString(step.getDividend());
			String nextMult = Integer.toString(step.getMult());
			String nextRem = Integer.toString(step.getRemainder());
			String nextIndent = Integer.toString(step.getIndent() + 1);
			String stringFormatter = "%" + nextIndent + "s%n";

			System.out.printf(stringFormatter, "_" + nextDiv);
			System.out.printf(stringFormatter, nextMult);
			System.out.printf(stringFormatter, countLines(nextDiv));

			if ((i + 1) == divisionSteps.size()) {
				String reminder = Integer.toString(step.getRemainder());

				System.out.printf(stringFormatter, reminder);
			}
		}
	}

	public static String countLines(String s) {
		StringBuilder result = new StringBuilder("");

		for (int i = 0; i < s.length(); i++) {
			result.append("-");
		}
		return result.toString();
	}

	public static String countSpaces(int firstLength, int secondLength) {
		String result = "";
		
		if (firstLength != secondLength) {
			result = Integer.toString(firstLength - secondLength);
		} 
		return result;
	}
}