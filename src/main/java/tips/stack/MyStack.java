package tips.stack;

import java.util.Arrays;

/**
 * @Description 自定义栈:基于数组
 * @Author yuki
 * @Date 2019/4/24 15:25
 * @Version 1.0
 **/
public class MyStack<E> {
    private Object[] data=null;//数据
    private int maxSize=0;//容量
    private int top=-1;//栈顶指针
    public MyStack() {
        this(10);//未指定时默认10
    }
    public MyStack(int initialSize) {
        if (initialSize>=0){
            maxSize=initialSize;
            data=new Object[initialSize];
        }else {
            throw new RuntimeException("初始大小不能小于0："+initialSize);
        }
    }
    //判空
    public boolean empty(){
        return top==-1;
    }
    //进栈
    public boolean push(E e){
        if ((top+1)==maxSize){
            throw new RuntimeException("栈已满，无法加入");
        }else {
            data[++top]=e;
            return true;
        }
    }
    //取出不清除
    public E peek(){
        if (empty()){
            throw new RuntimeException("栈为空");
        }else {
            return (E) data[top];
        }
    }
    //出栈
    public E pop(){
        if (empty()){
            throw new RuntimeException("栈为空");
        }else {
            E value= (E) data[top];
            data[top--]=null;
            return value;
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
