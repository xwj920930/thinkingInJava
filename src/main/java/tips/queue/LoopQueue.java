package tips.queue;

import java.util.Arrays;

/**
 * @Description 自定义队列：数组实现，循环队列
 * 在出队后，front变为   front = (front + 1) %QUEUE_CAPACITY 。
 * 例如队列最多容量为5，某一时刻front的值为4，则 (4+1)%5 =0 ，front就又会变成0。
 * 在入队后，rear变为:    rear = (rear + 1) %QUEUE_CAPACITY。
 * 0,1,2,3->
 * @Author yuki
 * @Date 2019/4/24 16:01
 * @Version 1.0
 **/
public class LoopQueue<E> {
    private Object[] data=null;//数据
    private int maxSize;//最大容量
    private int front;//队头，允许删除
    private int rear;//队尾，允许插入
    private int size=0;//当前容量
    public LoopQueue() {
        this(10);//默认10
    }
    public LoopQueue(int initialSize) {
        if (initialSize>=0){
            data=new Object[initialSize];
            maxSize=initialSize;
            front=rear=0;
        }else {
            throw new RuntimeException("初始化大小不能小于0："+initialSize);
        }
    }
    //判空
    public boolean empty(){
        return size==0;
    }
    //插入
    public boolean add(E e){
        if (rear==maxSize){
            throw new RuntimeException("队列已满，无法插入");
        }else {
            data[rear]=e;
            rear=(rear+1)%maxSize;
            size++;
            return true;
        }
    }
    //返回队首，但是不删除
    public E peek(){
        if (empty()){
            throw new RuntimeException("队列为空");
        }else {
            return (E) data[front];
        }
    }
    //出队
    public E pop(){
        if (empty()){
            throw new RuntimeException("队列为空");
        }else {
            E value= (E) data[front];
            data[front]=null;
            front=(front+1)%maxSize;
            size--;
            return value;
        }
    }
    //队列长度
    public int length(){
        return size;
    }
    @Override
    public String toString() {
        return Arrays.toString(data)+";"+length();
    }
}
