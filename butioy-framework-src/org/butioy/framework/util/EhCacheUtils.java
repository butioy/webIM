package org.butioy.framework.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.apache.log4j.Logger;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author butioy
 * Date 2015-09-10 23:53
 */
public class EhCacheUtils {

    final static Logger LOG = Logger.getLogger(EhCacheUtils.class);

    private static final String EHCACHE_CONFIG_PATH = "ehcache.xml";

    private CacheManager cacheManager;

    private static EhCacheUtils holder;

    private EhCacheUtils(String cachePath) {
        cacheManager = CacheManager.create(cachePath);
    }

    public static EhCacheUtils getInstance() {
        if( null == holder ) {
            holder = new EhCacheUtils(EHCACHE_CONFIG_PATH);
        }
        return holder;
    }

    /**
     * 获取指定名称的缓存对象
     * @param cacheName 缓存对象的名称
     * @return 缓存对象
     */
    public Cache getCache( String cacheName ) {
        return cacheManager.getCache(cacheName);
    }

    /**
     * 从指定名称的缓存中获取key指定的对象
     * @param cacheName 缓存名称
     * @param key 缓存的key
     * @return 缓存的key所指的对象
     */
    public Object getObjectCached( String cacheName, Serializable key ) {
        Cache cache = getCache(cacheName);
        if( null != cache ) {
            Element element = cache.get(key);
            if( null != element && !cache.isExpired(element) ) {
                return element.getObjectValue();
            }
        }
        return null;
    }

    public void put( String cacheName, Object key, Object value ) {
        Cache cache = getCache(cacheName);
        if(cache==null){
            /**
             * 2:允许内存中缓存对象的大小，这里是10000000
             * 3：允许在内存达到最大后写入磁盘
             * 4：表示永久保存
             * 5：最后两个参数表示element存活时间无穷大
             */
            cache= new Cache(cacheName, 1000000, true, true, 0, 0);
            cacheManager.addCache(cache);
        }else{
            try {
                cache.remove(key);
                Element elem = new Element(key, value);
                cache.put(elem);
            } catch (Exception e) {
                LOG.error("向缓存("+cacheName+") 加入 "+key+" 失败.", e);
            }
        }
    }

    /**
     * 获取指定名称的缓存中的指定key所对应的信息
     * @param cacheName 缓存名称
     * @param key 缓存中的key
     * @return 缓存中key对应的信息
     */
    public Element getElement( String cacheName, Object key ) {
        Cache cache = getCache(cacheName);
        return cache.get(key);
    }

    /**
     * 删除指定名称的缓存中的key所对应的数据
     * @param cacheName 缓存名称
     * @param key 需要删除的缓存key
     */
    public void removeElement( String cacheName, Object key ) {
        Cache cache = getCache(cacheName);
        if( null != cache ) {
            cache.remove(key);
        }
    }

    /**
     * 删除指定名称的缓存中的所有数据
     * @param cacheName 缓存名称
     */
    public void removeAll( String cacheName ) {
        Cache cache = getCache(cacheName);
        if( null != cache ) {
            cache.removeAll();
        }
    }

    /**
     * 删除指定名称的缓存对象
     * @param cacheName 缓存名称
     */
    public void removeCache( String cacheName ) {
        Cache cache = getCache(cacheName);
        if( null != cache )
            cacheManager.removeCache(cacheName);
    }

    /**
     * 停止缓存管理器
     */
    public void shutdown(){
        if(cacheManager!=null)
            cacheManager.shutdown();
    }
}
