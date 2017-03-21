package demo.java.nio.ibm;

import java.nio.FloatBuffer;

public class UseFloatBuffer {
	static public void main(String args[]) throws Exception {
		// 是创建缓冲区 容量大小为10个FLoat类型的数据
		FloatBuffer buffer = FloatBuffer.allocate(10);

		// 把缓存区填满
		for (int i = 0; i < buffer.capacity(); ++i) {
			float f = (float) Math.sin((((float) i) / 10) * (2 * Math.PI));
			buffer.put(f);
		}

		// 把buffer的指针指向头部
		buffer.flip();
		// buffer.hasRemaining() 判断buffer指针是否已经到达limit值
		while (buffer.hasRemaining()) {
			// buffer.get();从缓冲区获取一个数据并且将buffer指针往后指一位
			float f = buffer.get();
			System.out.println(f);
		}
	}

}
