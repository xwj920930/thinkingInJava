package tips.list;

/**
 * @Description 单向链表
 * 单向链表只可向一个方向遍历，一般查找一个节点的时候需要从第一个节点开始每次访问下一个节点，
 * 一直访问到需要的位置。而插入一个节点，对于单向链表，我们只提供在链表头插入，只需要将当前
 * 插入的节点设置为头节点，next指向原头节点即可。删除一个节点，我们将该节点的上一个节点的next
 * 指向该节点的下一个节点
 * @Author yuki
 * @Date 2019/4/28 16:36
 * @Version 1.0
 **/
public class SingleLinkedList {
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
    SingleLinkedList(){
        size=0;
        head=null;
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
        }else {
            newNode.next=head;
            head=newNode;
        }
        size++;
        return o;
    }
    //链头删除
    public Object deleteHead(){
        Object data = head.data;
        head=head.next;
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
    //反转
    public void reverse(){
        Node current=head;
        Node pre=null;
        while (current!=null){
            Node next=current.next;
            current.next=pre;
            if (next==null){
                head=current;
                return;
            }
            pre=current;
            current=next;
        }
    }
    //反向输出，运用递归
    public void printReversely(){
        printReversely(head);
    }
    public void printReversely(Node headNode){
        if (headNode!=null){
            printReversely(headNode.next);
            System.out.print(headNode);
        }
    }
    //没有size的情况下寻找中间点
    public Node searchMid(){
        Node slow=head;
        Node quick=head;
        while (quick!=null&&quick.next!=null&&quick.next.next!=null){
            slow=slow.next;
            quick=quick.next.next;
        }
        return slow;
    }
}
