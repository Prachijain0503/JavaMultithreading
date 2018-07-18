package net.codejava.multithreading;

public class Oddeventhread {

		boolean odd;
		int count = 1;
	 
		public void printOdd() {
			synchronized (this) {
				while (true) {
	 
					while (!odd) {
							try {
								wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}	
					}
					System.out.println("Odd Thread :" + count);
					count++;
					odd = false;
					notify();
				}
			}
		}
	 
		public void printEven() {
	 

			synchronized (this) {
				while (true) {
					while (odd) {
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					System.out.println("Even thread :" + count);
					count++;
					odd = true;
					notify();
	 
				}
			}
		}
	 
		public static void main(String[] args) {
	 
			Oddeventhread oep = new Oddeventhread();
			oep.odd = true;
			Thread t1 = new Thread(new Runnable() {
	 
				@Override
				public void run() {
					oep.printEven();
	 
				}
			});
			Thread t2 = new Thread(new Runnable() {
	 
				@Override
				public void run() {
					oep.printOdd();
	 
				}
			});
	 
			t1.start();
			t2.start();
	 
			try {
				t1.join();
				t2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	 
		}
	}
	 
