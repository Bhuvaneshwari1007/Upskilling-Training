package com.oops.polymorphism.animal;

public class Main {
	public static void main(String[] args) {
		Animal myAnimal = new Animal();
		Animal myDog = new Dog();
		Animal myPig = new Pig();
		
		myAnimal.animalSound();
		myDog.animalSound();
		myPig.animalSound();
	}
}
