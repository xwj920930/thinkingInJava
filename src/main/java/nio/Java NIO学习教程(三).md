一：channel通道到通道传输(无需buffer)
针对file类型的channel：transferFrom()/transferTo()
参考实例：ExampleTransfer.java

二：selector知识点
所有的Channel都归Selector管理，这些channel中只要有至少一个有IO动作，就可以通过Selector.select方法
检测到，并且使用selectedKeys得到这些有IO的channel，然后对它们调用相应的IO操作

通道必须处于非阻塞模式才能与选择器一起使用。这意味着无法将FileChannel与Selector一起使用，因为
FileChannel无法切换到非阻塞模式

三：SelectionKey(SelectionKey key = channel.register());
1.Interest Set
兴趣集是你感兴趣的“选择”事件集(Connect(连接),Accept(接收),Read(读),Write(写))
以下实例可用于判断是否包含某兴趣集
boolean isInterestedInAccept  = interestSet & SelectionKey.OP_ACCEPT;
多个兴趣集可以使用
int interestSet = SelectionKey.OP_ACCEPT | SelectionKey.OP_Read;

2.Ready Set是通道准备好的一组操作
selectionKey.isAcceptable();//server使用
selectionKey.isConnectable();//client使用
selectionKey.isReadable();
selectionKey.isWritable();

3.Attaching Objects将对象附加到SelectionKey
使用方式：
selectionKey.attach(theObject);
Object attachedObj = selectionKey.attachment();

四：Selector
1.select()方法返回只能是0或1
使用Selector注册一个或多个通道后，可以调用其中一个select( )方法。这些方法返回你感兴趣的事件
（连接，接收，读取或写入）并且“准备好”的通道。换句话说，如果你对准备好阅读的通道感兴趣，你将收
到准备好从这些select( )方法中阅读的通道

select( ) 阻塞，直到至少有一个频道为你注册的事件做好准备。
select(long timeout) 与select( )相同，只是它会阻塞最大超时时间(毫秒为单位)。
selectNow( ) 完全没有阻塞。它会立即返回任何已准备好的通道
select( )方法返回的int值表示准备好了多少个通道。也就是说，自*上次调用*select( )以来已经准备好了多少
个通道。如果你调用select( )并且它返回1，因为一个通道已准备好，并且你再次调用select( )，并且另一个
通道已准备好，它将再次返回1。如果你没有对第一个准备好的通道做任何事情，你现在有2个就绪通道，但每
次select()调用之间只有一个通道准备就绪(上次select的不计入这次的select,返回总为一)

2.selectedKeys()获取就绪通道
一旦调用了其中一个select()方法并且其返回值指示一个或多个通道已就绪，你可以通过调用选择器
selectedKeys( )方法，通过“选定的键集”访问就绪通道。
Set<SelectionKey> selectedKeys = selector.selectedKeys(); 

3.wakeUp( )
唤醒阻塞的select()
  
4.close( )
完成选择器后，调用其close( )方法。这将关闭Selector并使使用此Selector注册的所有SelectionKey实例无效,
Channel本身并未关闭。


selector实例：SelectorDemo.java