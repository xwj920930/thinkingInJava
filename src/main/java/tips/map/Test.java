package tips.map;

/**
 * @Author yuki
 * @Date 2019/6/17 11:03
 * @Version 1.0
 **/
public class Test {
    public static void main(String[] args) {
//        MySimpleMap simpleMap=new MySimpleMap();
//        simpleMap.put(1,"a");
//        simpleMap.put(2,"b");
//        System.out.println(simpleMap.containsKey(1));
//        System.out.println(simpleMap.get(2));
//        System.out.println(simpleMap);
//        System.out.println(simpleMap.containsValue("w"));
        MyHashMap hashMap=new MyHashMap();
        hashMap.put("1","a");
        hashMap.put("2","b");
        hashMap.put("2","c");
        hashMap.put(17,"c");
        System.out.println(hashMap.get("2"));
        System.out.println(hashMap);
    }
}
