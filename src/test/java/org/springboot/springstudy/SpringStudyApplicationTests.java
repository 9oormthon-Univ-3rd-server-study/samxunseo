package org.springboot.springstudy;

import org.junit.jupiter.api.Test;
import org.springboot.springstudy.coupon.repository.CouponRepository;
import org.springboot.springstudy.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SpringStudyApplicationTests {

	@Autowired
	private CouponService couponService;

	@Autowired
	private CouponRepository couponRepository;
	@Test
	void contextLoads() {
		couponService.publishCoupon(1L);

		long count = couponRepository.count();

		assertThat(count).isEqualTo(1);
	}

}
