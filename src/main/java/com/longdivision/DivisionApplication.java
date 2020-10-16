package com.longdivision;

import java.util.Scanner;

public class DivisionApplication {

	public static void main(String[] args) {
		DivisionPrinter printer;
		try(Scanner sc = new Scanner(System.in)) {
			System.out.print("Intput divident: ");
			int divident = sc.nextInt();
			System.out.print("Intput diviser: ");
			int diviser = sc.nextInt();
			printer = new DivisionPrinter(divident, diviser);
			printer.printBase();
			System.out.println(printer.getOutput());
		}
	}

}
