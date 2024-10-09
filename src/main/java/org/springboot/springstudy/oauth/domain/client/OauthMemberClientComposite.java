package org.springboot.springstudy.oauth.domain.client;

import org.springboot.springstudy.oauth.domain.OauthMember;
import org.springboot.springstudy.oauth.domain.OauthServerType;
import org.springframework.stereotype.Component;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Component
public class OauthMemberClientComposite {

    private final Map<OauthServerType, OauthMemberClient> mapping;

    public OauthMemberClientComposite(Set<OauthMemberClient> clients){
        mapping = clients.stream()
                .collect(toMap(
                        OauthMemberClient::supportServer,
                        identity()
                ));
    }

    public OauthMember fetch(OauthServerType oauthServerType, String authCode){
        return getClient(oauthServerType).fetch(authCode);
    }

    public OauthMemberClient getClient(OauthServerType oauthServerType){
        return Optional.ofNullable(mapping.get(oauthServerType))
                .orElseThrow(() -> new RuntimeException("지원하지 않는 소셜 로그인입니다."));
    }
}
