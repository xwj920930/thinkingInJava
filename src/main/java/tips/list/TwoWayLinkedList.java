package tips.list;

/**
 * @Description 双向链表
 * 我们知道单向链表只能从一个方向遍历，那么双向链表它可以从两个方向遍历。
 * @Author yuki
 * @Date 2019/4/28 16:36
 * @Version 1.0
 **/
public class TwoWayLinkedList {
    //节点
    private class Node{
        private Object data;//数据
        private Node prev;//上一节点
        private Node next;//下一节点
        Node(Object data){
            this.data=data;
        }
        @Override
        public String toString() {
            return data.toString();
        }
    }
    private int size;//链表个数
    private Node head;//头节点
    private Node tail;//尾节点
    TwoWayLinkedList(){
        size=0;
        head=null;
        tail=null;
    }
    //是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //链头添加
    public Object addHead(Object o){
        Node newNode=new Node(o);
        if (size==0){
            head=newNode;
            tail=newNode;
        }else {
            head.prev=newNode;
            newNode.next=head;
            head=newNode;
        }
        size++;
        return o;
    }
    //链尾添加
    public Object addTail(Object o){
        Node newNode=new Node(o);
        if (size==0){
            head=newNode;
            tail=newNode;
        }else {
            newNode.prev=tail;
            tail.next=newNode;
            tail=newNode;
        }
        size++;
        return o;
    }
    //链头删除
    public Object deleteHead(){
        if (size==0){
            return null;
        }
        Object data = head.data;
        head=head.next;
        head.prev=null;
        size--;
        return data;
    }
    //链尾删除
    public Object deleteTail(){
        if (size==0){
            return null;
        }
        Object data = tail.data;
        tail=tail.prev;
        tail.next=null;
        size--;
        return data;
    }
    @Override
    public String toString() {
        if (size==0){
            return "null";
        }
        int tempSize=size;
        Node current = head;
        StringBuilder builder=new StringBuilder();
        while (tempSize>0){
            builder.append(current.data.toString());
            current=current.next;
            tempSize--;
        }
        return builder.toString();
    }
    public String display() {
        if (size==0){
            return "null";
        }
        int tempSize=size;
        Node current = tail;
        StringBuilder builder=new StringBuilder();
        while (tempSize>0){
            builder.append(current.data.toString());
            current=current.prev;
            tempSize--;
        }
        return builder.toString();
    }
}
