package tips.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 缓存管理
 * @Author yuki
 * @Date 2018/8/7 9:48
 * @Version 1.0
 **/
public class CacheManager<T> {
    private Map<String,T> cache=new ConcurrentHashMap<>();
    public T getValue(Object key){
        return cache.get(key);
    }
    public void addOrUpdateCache(String key,T value){
        cache.put(key,value);
    }
    public void evictCache(String key){
        if(cache.containsKey(key)){
            cache.remove(key);
        }
    }
    public void evictCache(){
        cache.clear();
    }
}
