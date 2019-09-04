package tips.cache;

/**
 * @Description 自定义缓存测试
 * @Author yuki
 * @Date 2018/8/7 10:04
 * @Version 1.0
 **/
public class CacheUserTest {
    public static void main(String[] args) {
        CacheUserService service=new CacheUserService();
        service.getUserById("123");
        service.getUserById("123");
        service.reload();
        System.err.println("after reload ...");
        service.getUserById("123");
        service.getUserById("123");
    }
}
