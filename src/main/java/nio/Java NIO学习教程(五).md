一：ServerSocketChannel
1.普通模式
ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();//打开ServerSocketChannel
serverSocketChannel.socket().bind(new InetSocketAddress(9999));
while(true){
    SocketChannel socketChannel = serverSocketChannel.accept();//侦听传入连接，阻塞
    //do something with socketChannel...
}
serverSocketChannel.close();//关闭ServerSocketChannel

2.非阻塞模式
ServerSocketChannel可以设置为非阻塞模式。在非阻塞模式下，accept( )方法立即返回，如果没有到达
传入连接，则可以返回null。因此，必须检查返回的SocketChannel是否为null
ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
serverSocketChannel.socket().bind(new InetSocketAddress(9999));
serverSocketChannel.configureBlocking(false);//非阻塞
while(true){
    SocketChannel socketChannel = serverSocketChannel.accept();//侦听传入连接
    if(socketChannel != null){//注意，此处没有用selector，否则写法不同
        //do something with socketChannel...
    }
}

二：socket编程相关
1.原生java实现socket
SocketServerDemo.java/SocketClientDemo.java

2.nio实现socket
NioSocketServerDemo.java/NioSocketClientDemo.java