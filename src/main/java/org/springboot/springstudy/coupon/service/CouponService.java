package org.springboot.springstudy.coupon.service;

import lombok.RequiredArgsConstructor;
import org.springboot.springstudy.coupon.entity.Coupon;
import org.springboot.springstudy.coupon.repository.CouponRepository;
import org.springboot.springstudy.coupon.repository.RedisCouponRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CouponService {
    private final CouponRepository couponRepository;
    private final RedisCouponRepository redisCouponRepository;

    public boolean publishCoupon(Long userId){
        Long publishedCouponCounts = redisCouponRepository.increment();

        if(publishedCouponCounts > 200)
            throw new RuntimeException("더이상 발급 가능한 쿠폰 수량이 없습니다.");

        couponRepository.save(new Coupon(userId));

        return true;
    }
}
