package tips.queue;

import java.util.Arrays;

/**
 * @Description 自定义队列：数组实现，非循环,
 * pop以后的位置为null并且无法重新利用
 * @Author yuki
 * @Date 2019/4/24 16:01
 * @Version 1.0
 **/
public class MyQueue<E> {
    private Object[] data=null;//数据
    private int maxSize;//最大容量
    private int front;//队头，允许删除
    private int rear;//队尾，允许插入
    public MyQueue() {
        this(10);//默认10
    }
    public MyQueue(int initialSize) {
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
        return front==rear;
    }
    //插入
    public boolean add(E e){
        if (rear==maxSize){
            throw new RuntimeException("队列已满，无法插入");
        }else {
            data[rear++]=e;
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
            data[front++]=null;
            return value;
        }
    }
    //队列长度
    public int length(){
        return rear-front;
    }
    @Override
    public String toString() {
        return Arrays.toString(data)+";"+length();
    }
}
