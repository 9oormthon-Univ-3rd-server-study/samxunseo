package org.springboot.springstudy.oauth.infra.kakao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springboot.springstudy.oauth.domain.OauthMember;
import org.springboot.springstudy.oauth.domain.OauthServerType;
import org.springboot.springstudy.oauth.domain.client.OauthMemberClient;
import org.springboot.springstudy.oauth.infra.kakao.client.KakaoApiClient;
import org.springboot.springstudy.oauth.infra.kakao.dto.KakaoMemberResponse;
import org.springboot.springstudy.oauth.infra.kakao.dto.KakaoToken;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Slf4j
@Component
@RequiredArgsConstructor
public class KakaoMemberClient implements OauthMemberClient {

    private final KakaoApiClient kakaoApiClient;
    private final KakaoOauthConfig kakaoOauthConfig;

    @Override
    public OauthServerType supportServer(){
        return OauthServerType.KAKAO;
    }
    @Override
    public OauthMember fetch(String authCode){
        KakaoToken tokenInfo = kakaoApiClient.fetchToken(tokenRequestParams(authCode));
        log.info("tokenInfo: " + tokenInfo.tokenType());
        KakaoMemberResponse kakaoMemberResponse =
                kakaoApiClient.fetchMember("Bearer " + tokenInfo.accessToken());
        return kakaoMemberResponse.toDomain();
    }

    private MultiValueMap<String, String> tokenRequestParams(String authCode){
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();

        params.add("grant_type", "authorization_code");
        params.add("client_id", kakaoOauthConfig.clientId());
        params.add("redirect_uri", kakaoOauthConfig.redirectUri());
        params.add("code", authCode);
        params.add("client_secret", kakaoOauthConfig.clientSecret());

        return params;
    }
}
