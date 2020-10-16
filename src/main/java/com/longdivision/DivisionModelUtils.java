package com.longdivision;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DivisionModelUtils {
	
	private DivisionModelUtils() {
		
	}

	public static List<DivisionStep> fillListOfSteps(int divident, int diviser) {
		List<DivisionStep> result = new ArrayList<>();
		Stack<Integer> splittedByDigits = splitNumberByDigits(divident);

		while (!splittedByDigits.isEmpty()) {
			result.add(new DivisionStep(splittedByDigits, diviser));
		}
		return result;
	}

	public static Stack<Integer> splitNumberByDigits(int number) {
		Stack<Integer> result = new Stack<>();

		while (number >= 1) {
			result.push(number % 10);
			number /= 10;
		}
		return result;
	}

	public static void checkArguments(int divident, int diviser) {
		if ((divident < 0) || (diviser < 0)) {
			throw new IllegalArgumentException("Arguments must be positive");
		}
		if (diviser == 0) {
			throw new IllegalArgumentException("You cannot divide by zero");
		}
		if (diviser > divident) {
			throw new IllegalArgumentException("Dividend must be greater than or equal to the quotient");
		}
	}
}
