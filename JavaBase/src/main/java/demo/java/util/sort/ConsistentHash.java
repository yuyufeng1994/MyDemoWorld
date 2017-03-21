package demo.java.util.sort;

import java.util.Map.Entry;
import java.util.TreeMap;

//C为client客户端，S为service服务器
public class ConsistentHash<C, S> {
	// 虚拟节点的个数，默认200
	private int virtualNum;
	private long unit;// 移动
	// 存储服务器的容器
	private TreeMap<Integer, S> map = new TreeMap<>();

	public ConsistentHash() {
		this(200);
	}

	public ConsistentHash(int virtualNum) {
		this.virtualNum = virtualNum;
		unit = ((long) (Integer.MAX_VALUE / virtualNum) << 1) - 2;
	}

	// 添加服务器结点
	public void add(S s) {
		int hash = hash(s);
		// 保证分散到Integer的范围内
		for (int i = 0; i < virtualNum; i++)
			map.put((int) (hash + i * unit), s);
	}

	// 删除服务器结点
	public void remove(S s) {
		int hash = hash(s);
		// 保证分散到Integer的范围内,先转换为int再转换为Integer
		for (int i = 0; i < virtualNum; i++)
			map.remove((Integer) (int) (hash + i * unit));
	}

	// 获取服务器
	public S get(C c) {
		if (map.isEmpty())
			return null;
		int hash = hash(c);
		// TreeMap独有的取上和取下方法
		// ceiling 和 floor (Math中是ceil)
		Entry<Integer, S> entry = map.ceilingEntry(hash);
		if (entry == null) // 空就代表需要回环了
			return map.firstEntry().getValue();
		else
			return entry.getValue();
	}

	// 再次分散的hash方法
	private int hash(Object o) {
		if (o == null)
			return 0;
		int h = 0;
		h ^= o.hashCode();
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}
	

	public static void main(String[] args) {
		ConsistentHash<String, String> ch = new ConsistentHash<String, String>();
		ch.add("server1");
		ch.add("server2");
		ch.add("server3");
		System.out.println(ch.get("server1"));
	}
}
