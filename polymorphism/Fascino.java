package com.oops.polymorphism;

public class Fascino extends Bike{
	
		void run() {
			System.out.println("Running Safely with 60km");
		}
		public static void main(String[] args) {
			Bike b = new Fascino();
			b.run();
	}
}