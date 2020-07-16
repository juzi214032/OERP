package com.juzi.oerp.util;

import com.juzi.oerp.common.exception.CacheException;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

/**
 * 缓存加载工具
 *
 * @author Juzi
 * @date 2020/7/16 20:46
 */
public class CacheUtils {
    /**
     * 缓存实例
     *
     * @param cacheManager 缓存管理器
     * @param cacheName    缓存名称
     * @return 缓存实例
     */
    public static Cache getCache(CacheManager cacheManager, String cacheName) {
        Cache cache = cacheManager.getCache(cacheName);
        if (cache == null) {
            throw new CacheException(50000);
        }
        return cache;
    }
}
