package demo.java.net;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

//TCP编程例一：从客户端发送文件给服务器，服务器端保存到本地，并返回“发送成功”给客户端。并关闭相应的连接
public class TestTCP3 {
	// 客户端
	@Test
	public void client() throws Exception {
		// 1.创建Socket对象
		Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8989);
		// 2.从本地获取一个文件，发送给服务端
		OutputStream os = socket.getOutputStream();
		FileInputStream fis = new FileInputStream(new File("i://test/c1.jpg"));

		byte[] b = new byte[1024];
		int len;
		while ((len = fis.read(b)) != -1) {
			os.write(b, 0, len);
		}

		socket.shutdownOutput();
		// 3.接收来自于服务端的信息
		InputStream is = socket.getInputStream();
		byte[] b1 = new byte[1024];
		int len1;
		while ((len1 = is.read(b1)) != -1) {
			String str = new String(b1, 0, len1);
			System.out.print(str);
		}
		// 关闭相应的流
		is.close();
		os.close();
		fis.close();
		socket.close();

	}

	// 服务端
	@Test
	public void server() throws Exception {
		// 1.创建一个ServerSocket的对象
		ServerSocket ss = null;
		// 2.调用其accept方法，返回一个Socket对象
		Socket s = null;
		// 3. 将从客户端发送来的信息保存到本地
		InputStream is = null;
		FileOutputStream fos = null;

		ss = new ServerSocket(8989);
		s = ss.accept();
		is = s.getInputStream();
		fos = new FileOutputStream(new File("i://c11.jpg"));
		
		byte[] b = new byte[1024];
		int len;
		while ((len = is.read(b)) != -1) {
			fos.write(b, 0, len);
		}
		System.out.println("收到来自于"+s.getInetAddress().getHostAddress()+"的文件");
		// 4.发送“接收成功”的信息反馈给客户端
		OutputStream os = s.getOutputStream();
		os.write("你发送的图片我已接收成功！".getBytes());

		// 5.关闭相应的流和对象
		os.close();
		fos.close();
		is.close();
		s.close();
		ss.close();

	}
}
