package net.codejava.multithreading;

public class MultithreadingDemo extends Thread {
public void run(){
	System.out.println ("Thread " +
            Thread.currentThread().getId() +
            " is running");
}

}
