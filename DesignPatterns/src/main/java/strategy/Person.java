package strategy;

import java.util.Comparator;

public class Person implements Comparator<Person> {
	public Person() {
	}

	public Person(int age) {
		this.age = age;
	}

	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compare(Person o1, Person o2) {
		return o1.getAge() - o2.getAge();
	}

}
