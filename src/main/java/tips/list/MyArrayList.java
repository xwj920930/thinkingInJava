package tips.list;

import java.util.Arrays;

/**
 * @Description 自定义ArrayList
 * @Author yuki
 * @Date 2019/4/25 16:28
 * @Version 1.0
 **/
public class MyArrayList {
    private Object[] data;//数据
    private int index=0;//目前大小指针,有1个数据index为1
    MyArrayList(){
        this(10);
    }
    MyArrayList(int size){
        if (size<0)
            throw new RuntimeException("初始容量不能小于零");
        data=new Object[size];
    }
    public int size(){
        return index;
    }
    public void add(Object o){
        //是否装满
        if (index==data.length){
            //扩容
            Object[] newArray=new Object[2*index];
            //老数组拷贝到新数组
            System.arraycopy(data,0,newArray,0,data.length);
            data=newArray;
        }
        data[index++]=o;
    }
    public Object get(int index){
        return data[index];
    }
    public void remove(int index){
        //删除后前移
        //index以后的长度，有n个数据index为n
        int removeNum=this.index-index-1;
        if (removeNum>=0){
            System.arraycopy(data,index+1,data,index,removeNum);
            //最后一项置为null并且index减少
            data[this.index---1]=null;
        }
    }
    public void remove(Object o){
        for (int i=0;i<size();i++){
            if (data[i].equals(o)){
                remove(i);
            }
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(data)+";"+size();
    }
}
