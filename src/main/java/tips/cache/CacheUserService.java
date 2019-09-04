package tips.cache;

/**
 * @Description 服务
 * @Author yuki
 * @Date 2018/8/7 9:54
 * @Version 1.0
 **/
public class CacheUserService {
    private CacheManager<CacheUser> cacheManager;
    public CacheUserService() {
        cacheManager=new CacheManager<>();
    }
    public CacheUser getUserById(String userId){
        CacheUser user=cacheManager.getValue(userId);
        if(user!=null){
            System.err.println("get from cache ..."+userId);
            return user;
        }
        user=getFromDB(userId);
        if(user!=null){
            cacheManager.addOrUpdateCache(userId,user);
        }
        return  user;
    }

    public void reload(){
        cacheManager.evictCache();
    }

    private CacheUser getFromDB(String userId){
        System.err.println("get from db ..."+userId);
        return new CacheUser(userId);
    }
}
