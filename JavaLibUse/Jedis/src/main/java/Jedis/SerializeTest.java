package Jedis;

import java.util.ArrayList;
import java.util.List;

public class SerializeTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("123");
		list.add("456");
		list.add("789");
		List<String> listSub  = list.subList(0, 1);
		System.out.println(list.getClass());
		System.out.println(listSub.getClass());
		byte b[] = SerializeUtil.serialize(listSub);
		List<String> list2 =  (List<String>) SerializeUtil.unserialize(b);
		for(String s:list2){
			System.out.println(s);
		}
	}
}
