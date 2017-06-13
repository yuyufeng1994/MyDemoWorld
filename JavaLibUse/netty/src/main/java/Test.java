import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Test {
	public static void main(String[] args) throws Exception {
		Socket socket = null;
		OutputStream os = null;
		socket = new Socket(InetAddress.getByName("127.0.0.1"), 8080);
		os = socket.getOutputStream();
		os.write("abc132".getBytes());
		os.close();
		socket.close();
	}

}
