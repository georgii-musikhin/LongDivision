package com.longdivision;

import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class IntegerDivisionUtil {

	
	


	public static void main(String[] args) {
		DivisionModel d = new DivisionModel(10002, 2);
		d.fillListOfSteps();
		for (int i = 0; i < 10; i ++) {
			System.out.println(d.getDivisionSteps().get(i).getIndent());
			System.out.println(d.getDivisionSteps().get(i).getResult());
			System.out.println(d.getDivisionSteps().get(i).getMult());
			System.out.println(d.getDivisionSteps().get(i).getRemainder());
			System.out.println();
		}
	}

}
