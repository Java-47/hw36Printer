package telran.printer.model;

public class Printer implements Runnable {
	private int threadNumber;

	private Thread nextThread = null;
	private int portion;
	private int timesNeedToPrint;

	public Printer(int threadNumber, int portion, int timesNeedToPrint) {

		this.threadNumber = threadNumber;
		this.portion = portion;
		this.timesNeedToPrint = timesNeedToPrint;
	}

	public Thread getNextPrinter() {
		return nextThread;
	}

	public void setNextThread(Thread nextThread) {
		this.nextThread = nextThread;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			while (timesNeedToPrint > 0) {
				try {
					//stopper
					Thread.sleep(150);
				} catch (InterruptedException e2) {
				}
				for (int i = 0; i < portion; i++) {
					System.out.print(threadNumber);
					timesNeedToPrint--;
					if (timesNeedToPrint == 0) {
						break;
					}
				}

				System.out.println();
				nextThread.interrupt();

				if (timesNeedToPrint == 0) {
					System.out.println("Thread number: " + threadNumber + " Stopped");

					break;
				}
				try {
					Thread.sleep(200000);
				} catch (InterruptedException e1) {

				}

			}
		}
	}

	@Override
	public String toString() {
		return "Printer# " + threadNumber;
	}

}
