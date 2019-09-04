package tips.list;

/**
 * @Description 双端链表
 * 对于单项链表，我们如果想在尾部添加一个节点，那么必须从头部一直遍历到尾部，
 * 找到尾节点，然后在尾节点后面插入一个节点。这样操作很麻烦，如果我们在设计链
 * 表的时候多个对尾节点的引用，那么会简单很多
 * @Author yuki
 * @Date 2019/4/28 16:36
 * @Version 1.0
 **/
public class DoublePointLinkedList {
    //节点
    private class Node{
        private Object data;//数据
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
    DoublePointLinkedList(){
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
        if (head.next==null){
            head=null;
            tail=null;
        }else {
            head=head.next;
        }
        Object data = head.data;
        size--;
        return data;
    }
    //删除指定元素的节点
    public boolean delete(Object o){
        if (size==0){
            return false;
        }
        Node current = head;
        Node previous = head;
        //从前向后遍历
        while (current.data!=o){
            //最后一个
            if (current.next==null){
                return false;
            }else {
                previous=current;
                current=current.next;
            }
        }
        //删除第一个节点
        if (current==head){
            head=current.next;
            size--;
        }else {//删除的不是第一个节点
            previous.next=current.next;
            size--;
        }
        return true;
    }
    //查找
    public Node find(Object o){
        Node current=head;
        int tempSize=size;
        while (tempSize>0){
            if (current.data.equals(o)){
                return current;
            }else {
                current=current.next;
                tempSize--;
            }
        }
        return null;
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
}
