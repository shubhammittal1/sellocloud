package com.bmp.oms.service;

public class Test {
	public static void main(String[] args) {
		System.out.println("Main Thread"+ Thread.currentThread().getName());
		final A a = new A();
		Thread t = new Thread(new Runnable() {
	         public void run() {
	              a.getA();
	         }
		});
		t.start();
		System.out.println("Main Thread"+ Thread.currentThread().getName() + "End");
		System.out.println("Main Thread"+ Thread.currentThread().getName() + "End1");
	}
	
}

class A {
	public void getA () {
		System.out.println("Thread"+ Thread.currentThread().getName() + "Start");
		System.out.println("Amol");
		System.out.println("Thread"+ Thread.currentThread().getName() + "End");
	}
}