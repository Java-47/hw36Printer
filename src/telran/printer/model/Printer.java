package telran.printer.model;

public class Printer implements Runnable {
	private int threadNumber;

	private Printer nextPrinter = null;
	private int portion;
	private int printedTimes = 0;
	private int totalPrintTimes;

	public Printer(int threadNumber, int portion, int totalPrintTimes) {

		this.threadNumber = threadNumber;
		this.portion = portion;
		this.totalPrintTimes = totalPrintTimes;
	}

	public Printer getNextPrinter() {
		return nextPrinter;
	}

	public void setNextPrinter(Printer nextPrinter) {
		this.nextPrinter = nextPrinter;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			while (printedTimes < totalPrintTimes) {

				for (int i = 0; i < portion; i++) {
					System.out.print(threadNumber);
					printedTimes++;
					if(printedTimes>=totalPrintTimes) {
						break;
					}
				}
				try {
					System.out.println();
					Thread next = new Thread(nextPrinter);
					next.start();
					Thread.sleep(200);
					next.interrupt();

				} catch (InterruptedException e1) {
					e.printStackTrace();
				}
				break;
			}

		}
	}

	@Override
	public String toString() {
		return "Printer# " + threadNumber;
	}

}
