package org.myjee.cdi.practice.plainpojo.plainpjo_author;

public class InfiniteThread {

	private Thread thread1;
	private long beginTime;

	public void startThread() {
		Runnable thread = () -> {
			while (!Thread.interrupted()) {
				System.out.println("Thread Running...");
			}
		};
		thread1 = new Thread(thread, "Thread1");
		System.out.println("Thread Started: " + thread1.getName());
		beginTime = System.currentTimeMillis();
		thread1.start();
	}

	public void stopThread() {
		thread1.interrupt();
		System.out.println("Thread Interrupted: " + thread1.getName());
		System.out.println("Total Time taken in Seconds : " + (System.currentTimeMillis() - beginTime) / 100);
	}
}
