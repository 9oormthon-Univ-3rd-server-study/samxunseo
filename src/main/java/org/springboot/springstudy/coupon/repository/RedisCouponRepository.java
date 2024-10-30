package org.springboot.springstudy.coupon.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisCouponRepository {
    private final RedisTemplate<String, String> redisTemplate;

    public Long increment(){
        return redisTemplate.opsForValue().increment("coupon-count");
    }
}
