package nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Description selector使用
 * @Author yuki
 * @Date 2019/6/10 16:19
 * @Version 1.0
 **/
public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        Selector selector = Selector.open();//新建selector
        channel.configureBlocking(false);//非阻塞才能和selector共用
        channel.register(selector, SelectionKey.OP_ACCEPT);//将channel注册到selector
        while (true){
            int count = selector.selectNow();//是否存在OP_ACCEPT就绪的通道，非阻塞，可能返回null
            if (count == 0) continue;//不存在
            Set<SelectionKey> selectionKeys = selector.selectedKeys();//此时OP_ACCEPT就绪的所有通道
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                if (key.isConnectable()){
                    // a connection was established with a remote server.
                }
                else if (key.isAcceptable()){
                    // a connection was accepted by a ServerSocketChannel.
                }
                else if (key.isReadable()){
                    // a channel is ready for reading
                }
                else if (key.isWritable()){
                    // a channel is ready for writing
                }
                iterator.remove();//重要，手动清除已经操作过的key
            }
        }
    }
}
