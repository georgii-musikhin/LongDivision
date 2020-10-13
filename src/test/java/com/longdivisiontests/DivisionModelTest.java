package com.longdivisiontests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;

import com.longdivision.DivisionModel;

class DivisionModelTest {

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

}
