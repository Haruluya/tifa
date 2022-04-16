package com.tifa.framework.web.service;

import com.tifa.framework.web.pojo.Rating;
import com.tifa.framework.web.util.TifaConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    /**
     * 存储评分记录到redis。
     * @param rating    评分记录
     */
    public void storeRatingToRedis(Rating rating) {
        if (Boolean.TRUE.equals(redisTemplate.opsForList().getOperations().hasKey("userId:" + rating.getUserId())) && (redisTemplate.opsForList().size("userId:" + rating.getUserId()) >= TifaConstant.REDIS_PRODUCT_RATING_QUEUE_SIZE)) {
            redisTemplate.opsForList().leftPop("userId:" + rating.getUserId());
        }
        redisTemplate.opsForList().leftPush("userId:" + rating.getUserId(), rating.getProductId() + ":" + rating.getScore());
    }
}
