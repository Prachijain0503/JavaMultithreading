package net.codejava.multithreading;

public class Threethreadalternate {
	int num = 1;

	void printOne() {
		synchronized (this) {
			while(true) {
				if(num%3 == 1) {
					System.out.println("T1 : " + num);
					num++;
					notifyAll();
				}
				else {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		}
	}
	void printTwo() {
		synchronized (this) {
			while(true) {
				if(num%3 == 2) {
					System.out.println("T2 : "+num);
					num++;
					notifyAll();
				}
				else {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}}

	}
	void printThree() {
		synchronized (this) {
			while(true) {
				if(num%3 == 0) {
					System.out.println("T3 : "+num);
					num++;
					notifyAll();
				}
				else {
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Threethreadalternate th = new Threethreadalternate();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				th.printOne();

			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				th.printTwo();

			}
		});
		Thread t3 = new Thread(new Runnable() {
			@Override
			public void run() {
				th.printThree();

			}
		});
		t1.start();
		t2.start();
		t3.start();


	}

}
