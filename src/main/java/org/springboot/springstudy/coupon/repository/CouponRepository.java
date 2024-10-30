package org.springboot.springstudy.coupon.repository;

import org.springboot.springstudy.coupon.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
