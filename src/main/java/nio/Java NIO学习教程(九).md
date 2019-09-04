一：AsynchronousFileChannel异步channel
1.打开通道
Path path = Paths.get("data/test.xml");
AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path,StandardOpenOption.READ);

2.读取数据
2.1使用future读取
Future<Integer> operation = fileChannel.read(buffer, 0);
因为是异步，不知道何时结束，用轮训while(!operation.isDone());判断

2.2使用CompletionHandler获取
fileChannel.read(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
    @Override
    public void completed(Integer result, ByteBuffer attachment) {
    }
    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
    }
});
“attachment”是read( )方法的第三个参数，绑定对象，可以为null

3.写入数据
3.1使用future写入
Future<Integer> operation = fileChannel.write(buffer, position);

3.2使用CompletionHandler写入
fileChannel.write(buffer, position, buffer, new CompletionHandler<Integer, ByteBuffer>() {
    @Override
    public void completed(Integer result, ByteBuffer attachment) {
    }
    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
    }
});

4.实例：TestAsynchronousFileChannel1.java/TestAsynchronousFileChannel2.java