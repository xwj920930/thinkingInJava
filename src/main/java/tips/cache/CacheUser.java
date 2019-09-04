package tips.cache;

import java.io.Serializable;

/**
 * @Description 缓存测试实体
 * @Author yuki
 * @Date 2018/8/7 9:44
 * @Version 1.0
 **/
public class CacheUser implements Serializable{
    private String userId;
    private String userName;
    private int age;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "CacheUser{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }

    public CacheUser(String userId) {
        this.userId = userId;
    }
}
