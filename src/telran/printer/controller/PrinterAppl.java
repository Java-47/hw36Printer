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
		
		//create threads
		Thread[] threads = new Thread[printers.length];
		for (int i = 0; i < printers.length; i++) {
			threads[i] = new Thread(printers[i]);
		}
		
		//set Next Thread
		for (int i = 0; i < threads.length; i++) {
			printers[i].setNextThread(i == threads.length - 1 ? threads[0] : threads[i + 1]);	
		}
		
		//start threads
		for (int i = 0; i < threads.length; i++) {
			threads[i].start();
		}
		//interrupt first thread
		threads[0].interrupt();
		System.out.println("main thread stopped");
	}

}
