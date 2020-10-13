package com.longdivision;

import java.util.Scanner;

public class DivisionApplication {

	private static DivisionModel model;
	private static DivisionPrinter printer;

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("Intput divident: ");
			int divident = sc.nextInt();
			System.out.print("Intput diviser: ");
			int diviser = sc.nextInt();
			model = new DivisionModel(divident, diviser);
			printer = new DivisionPrinter(model);
			printer.printBase();
			System.out.println(printer.getOutput());
		}
	}

}
