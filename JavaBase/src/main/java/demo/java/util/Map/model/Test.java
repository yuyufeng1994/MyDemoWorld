package demo.java.util.Map.model;

public class Test {

	public static void main(String[] args) {
		MyMap<String, String> map = new MyMap<>();
		map.put("k1", "v1");
		map.put("k11", "v11");
		map.put("k2", "v2");
		map.put("k22", "v22");
		map.put("k3", "v3");
		map.put("k33", "v33");
		map.put("k23", "v23");
		map.put("k4", "v4");
		map.put("k41", "v41");
		map.put("k5", "value5");
		map.put("kabc", "vabc");
		map.put("k4", "v5");// 塞入相同的key，则覆盖
		System.out.println("删除k22: "+map.remove("k22"));
		System.out.println("删除k3: "+map.remove("k3"));
		map.printKVs();

		System.out.println("##获取key：k4 " + map.get("k4"));
		System.out.println("##获取key：k6 " + map.get("k6"));

		// System.out.println(hash("dasd"));

	}

	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

}
