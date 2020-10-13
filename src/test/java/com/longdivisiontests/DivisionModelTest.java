package com.longdivisiontests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import com.longdivision.DivisionModel;
import com.longdivision.DivisionStep;

class DivisionModelTest {
	
	private final DivisionModel model = new DivisionModel(1194, 2);
	private final DivisionStep firstStep = model.getDivisionSteps().get(0);
	
	@Test
	void checkDividentSucsess() {
		int expected = 1194;
		int actual = model.getDivident();
		assertEquals(expected, actual);
	}
	
	@Test
	void checkDiviserSucsess() {
		int expected = 2;
		int actual = model.getDiviser();
		assertEquals(expected, actual);
	}
	
	@Test
	void checkQuotientSucsess() {
		int expected = 597;
		int actual = model.getQuotient();
		assertEquals(expected, actual);
	}
	
	@Test
	void checkNumberOfStepsSucsess() {
		int expected = 3;
		int actual = model.getDivisionSteps().size();
		assertEquals(expected, actual);
	}
	
	@Test
	void checkDivOfFirstStepSucsess() {
		int expected = 11;
		int actual = firstStep.getDividend();
		assertEquals(expected, actual);
	}
	
	@Test
	void checkResultOfFirstStepSucsess() {
		int expected = 5;
		int actual = firstStep.getResult();
		assertEquals(expected, actual);
	}
	
	@Test
	void checkMultOfFirstStepSucsess() {
		int expected = 10;
		int actual = firstStep.getMult();
		assertEquals(expected, actual);
	}
	
	@Test
	void checkReminderOfFirstStepSucsess() {
		int expected = 1;
		int actual = firstStep.getRemainder();
		assertEquals(expected, actual);
	}

	@Test
	void splitNumberByDigitsSucsess() {
		Stack<Integer> expected = new Stack<Integer>();
		expected.push(4);
		expected.push(9);
		expected.push(1);
		expected.push(1);
		
		Stack<Integer> actual = DivisionModel.splitNumberByDigits(1194);
		assertEquals(expected, actual);
	}
	
	@Test
	void divideByZeroFailure() {
		assertThrows(IllegalArgumentException.class, () -> new DivisionModel(1, 0),
				"should throw IllegalArgumentException if you divide by zero");
	}
	@Test
	void dividentLessThanDiviserFailure() {
		assertThrows(IllegalArgumentException.class, () -> new DivisionModel(20, 50),
				"should throw IllegalArgumentException if divident less than diviser");
	}
	@Test
	void divideNegativeNumbersFailure() {
		assertThrows(IllegalArgumentException.class, () -> new DivisionModel(-1, -1),
				"should throw IllegalArgumentException if divident or diviser is negaive");
	}
}
