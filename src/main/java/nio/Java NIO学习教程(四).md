一：fileChannel
无法设置为非阻塞模式。它始终以阻塞模式运行(无法与selector共用)

1.打开FileChannel
需要通过InputStream，OutputStream或RandomAccessFile获取FileChannel
RandomAccessFile aFile = new RandomAccessFile("data.txt", "rw");
FileChannel inChannel = aFile.getChannel();

2.从FileChannel读取数据(将channel数据读入缓存)
ByteBuffer buf = ByteBuffer.allocate(48);
int bytesRead = inChannel.read(buf);//如果返回-1，则到达文件结尾

3.将数据写入FileChannel(将缓存写入channel)
String newData = "New String to write to file..." + System.currentTimeMillis();
ByteBuffer buf = ByteBuffer.allocate(48);
buf.clear();//写模式
buf.put(newData.getBytes());
buf.flip();//读模式
while(buf.hasRemaining()) {
    channel.write(buf);
}

4.关闭FileChannel
channel.close();   

5.Position
在读取或写入FileChannel时，你可以在特定位置执行此操作。
long pos = channel.position();
channel.position(pos +123);
如果你在文件结束后设置位置，并尝试从通道读取，你将得到-1——文件结束标记。
如果在文件结束后设置位置并写入通道，则文件将扩展以适合位置并写入数据。这可能导致“文件漏洞”，
其中磁盘上的物理文件在写入数据中存在间隙。

6.FileChannel大小
long fileSize = channel.size();    

7.FileChannel截断
channel.truncate(1024);

8.FileChannel Force
FileChannel.force( )方法将所有未写入的数据从通道刷新到磁盘。出于性能原因，操作系统可能会将数据
缓存在内存中，因此在调用该force( )方法之前，无法保证写入通道的数据实际写入磁盘。

二：SocketChannel
1.打开SocketChannel
SocketChannel socketChannel = SocketChannel.open();
socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));

2.关闭SocketChannel
socketChannel.close();    

3.从SocketChannel读取
ByteBuffer buf = ByteBuffer.allocate(48);
int bytesRead = socketChannel.read(buf);

4.写入SocketChannel
String newData = "New String to write to file..." + System.currentTimeMillis();
ByteBuffer buf = ByteBuffer.allocate(48);
buf.clear();
buf.put(newData.getBytes());
buf.flip();
while(buf.hasRemaining()) {
    channel.write(buf);
}

5.connect( )
如果SocketChannel处于非阻塞模式，并且你调用connect( )，则该方法可能会在建立连接之前返回。要确定
是否已建立连接，可以调用finishConnect()方法，如下所示：
socketChannel.configureBlocking(false);
socketChannel.connect(new InetSocketAddress("http://jenkov.com", 80));
while(! socketChannel.finishConnect() ){
    //wait, or do something else...    
}

6.write( )
在非阻塞模式下，write( )方法可能在没有写入任何内容的情况下返回。因此，需要在循环中调用write( )
方法。

7.read( )
在非阻塞模式下，read( )方法可能在没有读取任何数据的情况下返回。因此，需要注意返回的int，它告诉
读取了多少字节。

8.带Selector的非阻塞模式
使用Selector时，SocketChannel的非阻塞模式效果更好。通过使用选择器注册一个或多个SocketChannel，
可以向选择器询问准备好读取，写入等的通道