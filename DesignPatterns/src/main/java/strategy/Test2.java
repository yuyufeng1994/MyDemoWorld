package strategy;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		List<Person> list =new ArrayList<Person>();
		list.add(new Person(1));
		list.add(new Person(3));
		list.add(new Person(2));
		
		list.sort(new Person());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getAge());
		}
	}
}
/*
 * 运行结果：
 * 1
 * 2
 * 3
 */