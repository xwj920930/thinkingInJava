package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * udp通信接收方
 * channel.receive而非channel.read
 *
 */
public class DatagramChannelReceiver {
	public static void main(String[] args) {
		try {
			receive();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void receive() throws IOException{
		DatagramChannel channel =DatagramChannel.open();
		channel.configureBlocking(false);
		channel.socket().bind(new InetSocketAddress(10022));
		Selector selector = Selector.open();
		channel.register(selector, SelectionKey.OP_READ);
		while(selector.select()>0){
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				if (selectionKey.isReadable()) {
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					channel.receive(buffer);
					buffer.flip();
					System.out.println(new String(buffer.array(),0,buffer.limit()));
					buffer.clear();
				}
			}
			iterator.remove();
		}
		channel.close();
	}
}
