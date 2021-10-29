package com.lifengming.common.helper;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author lifengming
 * @date 2020.03.25
 */
@Slf4j
public class LocalCacheHelper {

    private final LoadingCache<String, BaseResponse> localCache = CacheBuilder.newBuilder()
            //设置过期时间
            .expireAfterWrite(90, TimeUnit.SECONDS)
            //最大数
            .maximumSize(500)
            .concurrencyLevel(128)
            .build(new CacheLoader<String, BaseResponse>() {
                @Override
                public BaseResponse load(String key) throws Exception {
                    //书写自己的逻辑
                    return findBaseResponseByKey(key);
                }
            });

    public BaseResponse getBaseResponse(String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        try {
            return localCache.get(key);
        } catch (ExecutionException e) {
            log.error("localCache get error:[{}]", e.getMessage());
        }
        return null;
    }

    private BaseResponse findBaseResponseByKey(String key) {
        BaseResponse baseResponse = new BaseResponse();
        System.out.println("get key");
        return baseResponse;

    }

    private class BaseResponse {
    }

    public static void main(String[] args) {
        LocalCacheHelper localCacheHelper = new LocalCacheHelper();

        localCacheHelper.getBaseResponse("key");

        System.out.println("===");
        localCacheHelper.getBaseResponse("key");


    }
}
