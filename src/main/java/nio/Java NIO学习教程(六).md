UDP协议是面向非连接（不可靠）的传输协议，也就是不需要与服务端建立连接，就直接将数据发送给服务端，
同时，无机制保证这条数据已成功发送给服务端。
TCP协议是面向连接（可靠）的传输协议，在客户端向服务器端传输数据之前，客户端必须与服务器端通过
“三次握手”来完成连接的建立，在之后的数据传输过程中，为了可靠传输，接受方还会发送ACK包来使发
送方获知该数据包已经成功发送，否则，发送端将重新发送数据包直至超时或发送成功。

一：DatagramChannel(用于udp)
1.打开DatagramChannel：
DatagramChannel channel = DatagramChannel.open();

2.接收数据receive()
ByteBuffer buf = ByteBuffer.allocate(48);
buf.clear();
channel.receive(buf);
receive( )方法将接收的数据包的内容复制到给定的Buffer中。如果接收的数据包包含的数据多于缓冲区可以
容纳的数据，则会以静默方式丢弃剩余的数据。

3.发送数据send()
String newData = "New String to write to file..." + System.currentTimeMillis();
ByteBuffer buf = ByteBuffer.allocate(48);
buf.clear();
buf.put(newData.getBytes());
buf.flip();
int bytesSent = channel.send(buf, new InetSocketAddress("jenkov.com", 80));
此示例将字符串发送到UDP端口80上的“jenkov.com”服务器。不过，没有人在监听那个端口，所以什么也不
会发生。由于UDP不对数据传送做出任何保证，因此不会通知你是否收到了发送数据包。

4.绑定网址
可以将DatagramChannel连接到网络上的特定地址。由于UDP是无连接的，因此这种连接到地址的方式不会像
TCP通道那样创建真正的连接。相反，它会锁定你的DatagramChannel，因此你只能从一个特定地址发送和接
收数据包。
channel.socket().bind(new InetSocketAddress(9999)); //类服务端
channel.connect(new InetSocketAddress("jenkov.com", 80));//类客户端

5.使用实例，见DatagramChannelReceiver.java/DatagramChannelSender.java

二：Pipe管道(2个线程之间的单向数据连接,FIFO结构)
1.创建Pipe
Pipe pipe = Pipe.open();

2.写入Pipe，需要访问接收器通道
Pipe.SinkChannel sinkChannel = pipe.sink();
String newData = "New String to write to file..." + System.currentTimeMillis();
ByteBuffer buf = ByteBuffer.allocate(48);
buf.clear();
buf.put(newData.getBytes());
buf.flip();
while(buf.hasRemaining()) {
    sinkChannel.write(buf);
}

3.从Pipe读取，需要访问源通道
Pipe.SourceChannel sourceChannel = pipe.source();
ByteBuffer buf = ByteBuffer.allocate(48);
int bytesRead = sourceChannel.read(buf);
read( )方法返回的int值表示读入缓冲区的字节数

4.使用实例参考TestPipe.java

二：Nio与Io
1.区别
非阻塞|阻塞，面向缓存|面向流，selector|无对应

2.Io面向流每次读取一个和多个字节，不缓存；Nio需要检查缓冲区是否包含你完全处理它所需的所有数据。
而且，你需要确保在向缓冲区中读取更多数据时，不会覆盖尚未处理的缓冲区中的数据，处理稍复杂

3.IO当一个线程调用一个read( )或write( )时，该线程被阻塞，直到有一些数据需要读取，或者数据被完全
写入为止。同时，线程无法执行任何其他操作；NIO的非阻塞模式允许线程请求从通道读取数据，并且只获得
当前可用的内容，或者根本没有数据，如果当前没有数据可用。线程可以继续执行其他操作。也就是说，单个
线程现在可以管理多个输入和输出通道

4.Selectors允许单个线程监视多个输入通道。你可以使用选择器注册多个通道，然后使用单个线程“选择”
具有可用于处理的输入的通道，或者选择准备好写入的通道。这种选择器机制使得单个线程可以轻松管理多
个通道

5.总结
NIO允许你仅使用一个（或几个）线程来管理多个通道（网络连接或文件），但成本是解析数据可能比从阻塞
流中读取数据时更复杂。
如果你需要同时管理数千个打开的连接，每个链接只发送少量数据，例如聊天服务器，在NIO中实现该服务器
可能是一个优势。同样，如果你需要与其他计算机保持大量开放连接，例如在P2P网络中，使用单个线程来管
理所有出站连接可能是一个优势。
如果你的连接较少，带宽很高，一次发送大量数据，那么经典的IO服务器实现可能是最合适的