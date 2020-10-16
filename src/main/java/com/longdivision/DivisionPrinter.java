package com.longdivision;

import java.util.List;

public class DivisionPrinter {
	private DivisionModel model;
	private StringBuilder output = new StringBuilder();

	public DivisionPrinter(int divident, int diviser) {
		model = new DivisionModel(divident, diviser);
	}

	public void printBase() {
		String divident = Integer.toString(model.getDivident());
		String diviser = Integer.toString(model.getDiviser());
		String quotient = Integer.toString(model.getQuotient());
		List<DivisionStep> divisionSteps = model.getDivisionSteps();
		
		DivisionStep firstStep = model.getDivisionSteps().get(0);
		String firstDiv = Integer.toString(firstStep.getDividend());
		String firstMult = Integer.toString(firstStep.getMult());
		String firstStringFormatter = "_%s|%s\n";
		String space = countSpaces((divident.length() + 1), firstDiv.length());
		String nextStringsormatter = " %s%" + space + "s%s\n";

		output.append(String.format(firstStringFormatter, divident, diviser));
		output.append(String.format(nextStringsormatter, firstMult, "|", countLines(quotient)));
		output.append(String.format(nextStringsormatter, countLines(firstMult), "|", quotient));

		if (divisionSteps.size() > 1) {
			printDivision();
		} else {
			String firstRemiinder = Integer.toString(firstStep.getRemainder());
			String secondStringsormatter = " %" + firstDiv.length() + "s";

			output.append(String.format(secondStringsormatter, firstRemiinder));
		}
	}

	public void printDivision() {
		List<DivisionStep> divisionSteps = model.getDivisionSteps();
		
		for (int i = 1; i < divisionSteps.size(); i++) {
			DivisionStep step = divisionSteps.get(i);
			String nextDiv = Integer.toString(step.getDividend());
			String nextMult = Integer.toString(step.getMult());
			String nextIndent = Integer.toString(step.getIndent() + 1);
			String stringFormatter = "%" + nextIndent + "s\n";

			output.append(String.format(stringFormatter, "_" + nextDiv));
			output.append(String.format(stringFormatter, nextMult));
			output.append(String.format(stringFormatter, countLines(nextDiv)));

			if ((i + 1) == divisionSteps.size()) {
				String reminder = Integer.toString(step.getRemainder());

				output.append(String.format(stringFormatter, reminder));
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
	public String getOutput() {
		return output.toString();
	}
}