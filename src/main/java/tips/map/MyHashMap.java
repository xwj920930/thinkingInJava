package tips.map;

import java.util.Arrays;

/**
 * @Description HashMap由数组+链表组成的，
 * 数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的
 * @Author yuki
 * @Date 2019/6/17 10:38
 * @Version 1.0
 **/
public class MyHashMap {
    class Node{//内部使用链表
        int hash;
        Object key;
        Object value;
        Node next;
        Node(int hash, Object key, Object value, Node next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "hash=" + hash +
                    ", key=" + key +
                    ", value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
    private Node[] table=new Node[16];//外部存储结构数组
    private int size=0;//长度
    private int indexFor(int hashValue, int length){ //获取插入的位置
        return hashValue%length;
    }
    private int hash(Object key){//获取hash值
        return key.hashCode();
    }
    public Object get(Object key){
        int hash=hash(key);//获取hash值
        int i=indexFor(hash,table.length);//获取插入的位置
        for (Node node=table[i];node!=null;node=node.next){//得到该位置链表
            if (key.equals(node.key)&&hash==node.hash)
                return node.value;
        }
        return null;
    }
    public Object put(Object key,Object value){
        int hash=hash(key);//通过key,求hash值
        int i = indexFor(hash, table.length); //通过hash,找到这个key应该放的位置
        //处理链表中存在旧值的情况
        for (Node node=table[i];node!=null;node=node.next){
            if (key.equals(node.key)&&hash==node.hash){ //覆盖旧value
                Object oldValue = node.value;
                node.value=value;
                return oldValue;
            }
        }
        addEntry(key,value,hash,i);
        return null;
    }
    //新增entry或者增加链表长度
    private void addEntry(Object key,Object value,int hashValue,int i) {
        int capacity=size;
        if (capacity==table.length){//扩容
            Node[] newTable=new Node[table.length*2];
            System.arraycopy(table,0,newTable,0,table.length);
            table=newTable;
        }
        Node node=table[i];//位置i的已有链表(可以有可以空)
        if (node == null)//新增entry，否则增加链表长度
            size++;
        table[i]=new Node(hashValue,key,value,node);//置于最前
    }
    @Override
    public String toString() {
        return "MyHashMap{" +
                "table=" + Arrays.toString(table) +
                ", size=" + size +
                '}';
    }
}
