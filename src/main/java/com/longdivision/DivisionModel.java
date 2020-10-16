package com.longdivision;

import java.util.ArrayList;
import java.util.List;

public class DivisionModel {

	private int divident;
	private int diviser;
	private int quotient;
	private List<DivisionStep> divisionSteps;

	public DivisionModel(int divident, int diviser) {
		DivisionModelUtils.checkArguments(divident, diviser);

		this.divident = divident;
		this.diviser = diviser;
		this.quotient = divident / diviser;
		this.divisionSteps = new ArrayList<>();
		this.divisionSteps = DivisionModelUtils.fillListOfSteps(divident, diviser);
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
