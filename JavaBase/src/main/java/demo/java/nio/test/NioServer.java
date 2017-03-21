package demo.java.nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioServer {
	private static ByteBuffer buffer = ByteBuffer.allocate(10);

	public static void main(String[] args) throws Exception {

		// Create a new selector
		Selector selector = Selector.open();

		// Open a listener on each port, and register each one
		// with the selector
		ServerSocketChannel sSc = ServerSocketChannel.open();
		sSc.configureBlocking(false);
		ServerSocket ss = sSc.socket();
		InetSocketAddress address = new InetSocketAddress(8080);
		ss.bind(address);

		SelectionKey sKey = sSc.register(selector, SelectionKey.OP_ACCEPT);

		System.out.println("Going to listen on " + 8080);

		while (true) {
			int num = selector.select();
			if (num <= 0) {
				continue;
			}
			Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();
			while (keyIter.hasNext()) {
				final SelectionKey key = keyIter.next();

				// key.isAcceptable（）如果为true，说明channnel支持accept(),也就是说明是一个ServerSocketChannel
				if (key.isAcceptable()) {
					SocketChannel clientChannel = sSc.accept();
					if (clientChannel != null) {
						clientChannel.configureBlocking(false);
						clientChannel.register(selector, SelectionKey.OP_READ);
					}

				}
				// 如果isReadable()为true,说明是一个SocketChannel
				if (key.isReadable()) {
					String requestContent = read(key);
					// 业务处理
					SocketChannel socketChannel = (SocketChannel) key.channel();
					key.interestOps(SelectionKey.OP_READ | SelectionKey.OP_WRITE);
				}

				if (key.isValid() && key.isWritable()) {
					write(key, "ok");
				}
				keyIter.remove();
			}
		}
	}

	private static void write(SelectionKey key, String str) throws Exception {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		buffer.clear();
		buffer.put(str.getBytes());
		buffer.flip();
		socketChannel.write(buffer);

	}

	private static String read(SelectionKey key) throws IOException {
		SocketChannel socketChannel = (SocketChannel) key.channel();

		buffer.clear();

		int len = 0;

		StringBuffer str = new StringBuffer();

		while ((len = socketChannel.read(buffer)) > 0) {

			byte[] bs = buffer.array();

			String block = new String(bs, 0, len);

			System.out.println("Server read: " + block);

			str.append(block);

		}

		buffer.clear();

		return str.toString();
	}
}
