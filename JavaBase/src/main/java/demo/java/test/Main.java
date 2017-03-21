package demo.java.test;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		String no="1,2,3";
		for(String n:no.split(",")){
			System.out.println(n);
		}
		List<String> list = new ArrayList<String>();

	}
}

class Aob {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

class Bob extends Aob{
	private String age;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
}
