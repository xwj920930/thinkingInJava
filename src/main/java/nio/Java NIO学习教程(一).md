一：概念
Selectors：单个线程可以监视多个通道的数据(多路复用)
Buffer：缓冲区
Channels与流类似但是有区别：
1.你可以读取和写入Channels。流通常是单向的（读或写）。
2.Channels可以异步读取和写入。
3.Channels始终读取缓冲区或从缓冲区写入

实例类：
ExampleRead.java
ExampleWrite.java
ExampleCopy.java

参考：https://blog.csdn.net/qq_33704186/article/details/87691520