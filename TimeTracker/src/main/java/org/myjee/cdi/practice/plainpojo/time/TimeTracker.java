package org.myjee.cdi.practice.plainpojo.time;

public class TimeTracker {

	private Thread thread1;
	private long beginTime;

	public void startThread() {
		Runnable thread = () -> {
			while (!Thread.interrupted()) {
			}
		};
		thread1 = new Thread(thread, "TimeTracker");
		beginTime = System.currentTimeMillis();
		System.out.println("Started: " + thread1.getName() + " :: " + beginTime);
		thread1.start();
	}

	public void stopThread() {
		thread1.interrupt();
		System.out.println("Stopped: " + thread1.getName() + "::" + System.currentTimeMillis());
		System.out.println("Total Time taken (in milli-Seconds) : " + (System.currentTimeMillis() - beginTime));
	}
}
