package tips.set;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Description HashSet是基于HashMap实现的，默认构造函数是构建一个初始容量为16，负载因子为0.75
 * 的HashMap。封装了一个 HashMap对象来存储所有的集合元素，所有放入HashSet中的集合元素实际上
 * 由 HashMap的key来保存，而HashMap的value则存储了一个PRESENT，它是一个静态的Object对象
 * @Author yuki
 * @Date 2019/6/17 10:20
 * @Version 1.0
 **/
public class MyHashSet<E> {
    private Map<E,Object> map;//存储结构
    private static final Object PRESENT=new Object();//虚拟object
    MyHashSet(){
        map=new HashMap<>();
    }
    public boolean add(E e){
        //hashMap.put返回与key关联的旧值；如果没有旧值，则返回null
        return map.put(e,PRESENT) == null;
    }
    public boolean remove(E e){
        return map.remove(e) == PRESENT;
    }
    public int size(){
        return map.size();
    }
    public boolean contains(E e){
        return map.containsKey(e);
    }
    public Iterator iterator(){
        return map.keySet().iterator();
    }
}
