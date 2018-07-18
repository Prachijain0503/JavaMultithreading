package net.codejava.multithreading;

public class Multithread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int n = 8; // Number of threads
        for (int i=0; i<8; i++)
        {
		MultithreadingDemo t1 = new MultithreadingDemo();
		t1.start();
        }
	}

}
