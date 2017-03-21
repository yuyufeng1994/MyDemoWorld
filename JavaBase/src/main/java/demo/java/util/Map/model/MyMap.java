package demo.java.util.Map.model;

/**
 * Map的模拟
 * 
 * @author yuyufeng
 *
 * @param <K>
 * @param <V>
 */
public class MyMap<K, V> {
	/**
	 * 当length = 2^n时，不同的hash值发生碰撞的概率比较小，这样就会使得数据在table数组中分布较均匀，查询速度也较快
	 * （扩容时其中的indexFor -> h & (length-1)) 这里就不做处理，模拟时只做%length
	 */
	static final int ARRAYMAX = 16;

	/**
	 * 构造函数初始化数组
	 */
	public MyMap() {
		table = new Node[ARRAYMAX];
	}

	/**
	 * 数组
	 */
	Node<K, V>[] table;

	/**
	 * 获取key的hash值
	 * 
	 * @param key
	 * @return
	 */
	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}

	/**
	 * 根据key获取value
	 * 
	 * @param key
	 * @return
	 */
	public V get(Object key) {
		int index = hash(key) % ARRAYMAX;
		Node<K, V> p = table[index];
		while (p != null) {
			if (p.key.equals(key)) {
				break;
			}
			p = p.next;
		}
		if (p == null) {
			return null;
		}
		return p.value;
	}

	/**
	 * put key-vlaue
	 * 
	 * @param key
	 * @param value
	 */
	public void put(K key, V value) {
		Node<K, V> p, q;
		// 计算key需要存放的在table数组中的位置
		int index = hash(key) % ARRAYMAX;
		// 每个table都挂上node，node的如何均匀分布、如何效率这里不做要求
		if (table[index] == null) {
			table[index] = new Node(hash(key), key, value, null);
		} else {
			q = table[index];
			// p = q.next;
			p = q;
			boolean flag = true;
			while (p != null) {
				// 如果已经存在，则覆盖
				if (key.equals(p.key)) {
					flag = false;
					p.value = value;
					break;
				}
				q = p;
				p = p.next;
			}

			if (flag) {
				p = new Node(hash(key), key, value, null);
				q.next = p;
			}

		}
	}

	/**
	 * 打印所有key-value
	 */
	public void printKVs() {
		Node<K, V> p;
		for (int i = 0; i < ARRAYMAX; i++) {
			p = table[i];
			System.out.println("[table] " + i + " ->");
			while (p != null) {
				System.out.println(p.key + " " + p.value);
				p = p.next;
			}
		}
	}

	/**
	 * 删除key-value
	 * 
	 * @param key
	 * @return
	 */
	public V remove(Object key) {
		int index = hash(key) % ARRAYMAX;
		Node<K, V> p = table[index];
		Node<K, V> q;
		q = table[index];
		while (p != null) {
			if (p.key.equals(key)) {
				if (q.next == null) {
					System.out.println("next==null");
					System.out.println("index " + index);
					if (table[index].key == q.key) {
						table[index] = null;
					} else {
						q = null;
					}
				} else {
					q.next = p.next;
				}
				break;
			}
			q = p;
			p = p.next;
		}
		if (p == null) {
			return null;
		}
		return p.value;
	}

}

class Node<K, V> {
	int hash;
	K key;
	V value;
	Node<K, V> next;

	public Node() {

	}

	public Node(int hash, K key, V value, Node<K, V> next) {
		this.hash = hash;
		this.key = key;
		this.value = value;
		this.next = next;
	}

}