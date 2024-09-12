package org.springboot.springstudy.oauth.service;

import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springboot.springstudy.security.jwt.JwtUtil;
import org.springboot.springstudy.user.UserRepository;
import org.springboot.springstudy.user.domain.User;
import org.springboot.springstudy.user.dto.response.TokenResponse;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OAuthService {
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    public TokenResponse register(String email){
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty()){
            User newUser = User.builder()
                    .email(email)
                    .username(RandomStringUtils.randomAlphabetic(4))
                    .password(RandomStringUtils.randomAlphabetic(15))
                    .roles(Collections.singletonList("ROLE_USER"))
                    .build();
            userRepository.save(newUser);
        }
        return TokenResponse.builder()
                .accessToken(jwtUtil.createAccessToken(email))
                .build();
    }
}
