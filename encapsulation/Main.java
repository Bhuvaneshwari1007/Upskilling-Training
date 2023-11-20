package com.encapsulation;

public class Main {
	public static void main(String[] args) {
		
		Car car1= new Car();
		
		car1.setColor("Blue");
		car1.setSpeed(150);
		
		System.out.println("Car color: "+ car1.getColor());
		System.out.println("Car Speed: "+ car1.getSpeed());
	}
}