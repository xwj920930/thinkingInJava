package jdk8;

import java.util.Optional;

/**
 * @Description optional用于判断空
 * 但是也有局限，语句中不能返回Boolean，只能返回对象，null，异常
 * @Author yuki
 * @Date 2019/3/22 17:21
 * @Version 1.0
 **/
class Name{
    public String name;
    Name(String name){
        this.name=name;
    }
}
class User{
    public Name name;
    User(Name name){
        this.name=name;
    }
}
public class NewOptional {
    private static String getUser(User user){
        //一般写法
//        if (user==null){
//            return "unKnown";
//        }else {
//            return user.name;
//        }
        return Optional.ofNullable(user)
                //如果存在值，则将提供的映射函数应用于该函数(类似stream中的map转换)，
                // 如果结果不为空，则返回Optional描述结果(一路下来都非空才这样写)
                .map(u->u.name)
                .map(n->n.name)
                .orElse("unKnown");
    }
    private static void a(User user){
//        if(user!=null){
//            System.out.println();
//        }
        Optional.ofNullable(user)
                .ifPresent(user1 -> {
            System.out.println();
                });
        System.out.print(Optional.ofNullable(user).orElse(new User(new Name(""))).name);
        //作用都是非空的简单写法，貌似第一种更简洁
    }
    private static User b(User user){
//         if(user!=null){
//        String name = user.getName();
//        if("zhangsan".equals(name)){
//            return user;
//        }
//    }else{
//        user = new User();
//        user.setName("zhangsan");
//        return user;
//    }
        return Optional.ofNullable(user)
                .filter(user1 ->"zhangsan".equals(user1.name))
                .orElseGet(()->{
                    return null;
                });
    }
    public static void main(String[] args) {
        Name name=null;
        User user=new User(name);
//        Optional最初始用法
//        Optional<User> optional=Optional.ofNullable(user);
//        if (optional.isPresent()){
//            optional.get().name="";
//        }
        System.out.println(NewOptional.getUser(user));
        a(user);
        System.out.println(b(user));;
    }
}
