package telran.printer.controller;

import telran.printer.model.Printer;

public class PrinterAppl {
	static final int TOTALPRINTTIMES = 100;
	static final int PORTION = 9;
	static final int PRINTERSCOUNT = 4;

	public static void main(String[] args){
		Printer[] printers = new Printer[PRINTERSCOUNT];

		// Printers create. Printer(name, PORTION, TOTALPRINTTIMES)
		
		for (int i = 0; i < PRINTERSCOUNT; i++) {
			printers[i] = new Printer(i, PORTION, TOTALPRINTTIMES);
		}
		// set nextPrinter for Printers
		for (int i = 0; i < printers.length; i++) {
			printers[i].setNextPrinter(i == printers.length - 1 ? printers[0] : printers[i + 1]);

		}
		// create first thread
		Thread thread = new Thread(printers[0]);
		thread.start();
		thread.interrupt();
		System.out.println("main thread stopped");
	}

}
