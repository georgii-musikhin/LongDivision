package com.longdivisiontests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.longdivision.DivisionModel;
import com.longdivision.DivisionPrinter;

class DivisionPrinterTest {
	
	private final DivisionModel model = new DivisionModel(1823000002, 13);
		
	@BeforeAll
	void testModelPrintSuccess() {
		String expected = "_1823000002|13\n"
				        + " 13        |---------\n"
				        + " --        |140230769\n"
				        + " _52\n"
				        + "  52\n"
				        + "  --\n"
				        + "   _30\n"
				        + "    26\n"
				        + "    --\n"
				        + "    _40\n"
				        + "     39\n"
				        + "     --\n"
				        + "     _100\n"
				        + "       91\n"
				        + "      ---\n"
				        + "       _90\n"
				        + "        78\n"
				        + "        --\n"
				        + "       _122\n"
				        + "        117\n"
				        + "        ---\n"
				        + "          5\n";
		
		DivisionPrinter printer = new DivisionPrinter(model);
		printer.printBase();
		String actual = printer.getOutput();
		assertEquals(expected, actual);
	}
}
