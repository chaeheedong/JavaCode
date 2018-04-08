package exceptionEx.Ex2;

public class ClassCastExceptionExample {

	class Animal {
	}

	class Dog extends Animal {
	}

	class Cat extends Animal {
	}

	public static void changeDog(Animal animal) {

		//if (animal instanceof Dog) {

			Dog dog = (Dog) animal; // ClassCastException 발생 가능

		//}

	}

	public static void main(String[] args) {

		Dog dog = new Dog();
		changeDog(dog);

		Cat cat = new Cat();
		changeDog(cat);

	}

}
