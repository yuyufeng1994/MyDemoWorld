package demo.java.util.Map;

import java.util.HashMap;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		Map<Long, String> map = new HashMap<>();
		map.put(2l, "v2");
		System.out.println(map.get(2l));

	}

}
