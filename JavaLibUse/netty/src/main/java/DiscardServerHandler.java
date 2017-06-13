import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.*;

public class DiscardServerHandler extends SimpleChannelHandler {

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
		e.getCause().printStackTrace();
		Channel ch = e.getChannel();
		ch.close();
	}

	@Override
	public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
		ChannelBuffer buf = (ChannelBuffer) e.getMessage();
		while (buf.readable()) {
			System.out.print((char) buf.readByte());
			System.out.flush();
		}
		System.out.println();
	}

}
