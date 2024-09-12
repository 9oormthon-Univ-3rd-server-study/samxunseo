package org.springboot.springstudy.user.dto.response;

import lombok.Builder;

@Builder
public record TokenResponse(
        String accessToken,
        String refreshToken
) {}