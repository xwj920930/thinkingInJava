package tips.map;

import java.util.Arrays;

/**
 * @Description 简单map
 * 没有用到hash定位，相当于一个萝卜一个坑
 * @Author yuki
 * @Date 2019/6/17 10:38
 * @Version 1.0
 **/
public class MySimpleMap {
    class Entry{
        Object key;
        Object value;
        Entry(Object key, Object value){
            this.key=key;
            this.value=value;
        }
        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
    private Entry[] array;//array.length不变
    private int size;//目前大小
    MySimpleMap(){
        this(10);
    }
    private MySimpleMap(int len){
        array=new Entry[len];
    }
    private boolean isEmpty(){
        return size == 0;
    }
    private Entry[] expand(Entry[] array){
        Entry[] newArray=new Entry[array.length*2+1];
        System.arraycopy(array,0,newArray,0,array.length);
        array=newArray;
        return array;
    }
    public boolean put(Object key,Object value){
        if (size == array.length)
            array=expand(array);
        for (int i = 0; i < size; i++) {
            if (key.equals(array[i].key)){
                array[i].value=value;
                return true;
            }
        }
        array[size]=new Entry(key,value);
        size++;
        return true;
    }
    public Object get(Object key){
        if (!isEmpty()){
            for (int i = 0; i < size; i++) {
                if (key.equals(array[i].key))
                    return array[i].value;
            }
        }
        return null;
    }
    public boolean containsKey(Object key){
        for (int i = 0; i < size; i++) {
            if (key.equals(array[i].key))
                return true;
        }
        return false;
    }
    boolean containsValue(Object value){
        for (int i = 0; i < size; i++) {
            if (value.equals(array[i].value))
                return true;
        }
        return false;
    }
    @Override
    public String toString() {
        return "MySimpleMap{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }
}
