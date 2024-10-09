package org.springboot.springstudy.oauth.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springboot.springstudy.oauth.domain.OauthMember;
import org.springboot.springstudy.oauth.domain.OauthMemberRepository;
import org.springboot.springstudy.oauth.domain.OauthServerType;
import org.springboot.springstudy.oauth.domain.authcode.AuthCodeRequestUrlProviderComposite;
import org.springboot.springstudy.oauth.domain.client.OauthMemberClientComposite;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OauthService {

    private final AuthCodeRequestUrlProviderComposite authCodeRequestUrlProviderComposite;
    private final OauthMemberClientComposite oauthMemberClientComposite;
    private final OauthMemberRepository oauthMemberRepository;

    public Long login(OauthServerType oauthServerType, String authCode){
        OauthMember oauthMember = oauthMemberClientComposite.fetch(oauthServerType,authCode);
        log.info("oauthMember : " + oauthMember.nickname() + "fetch is called");
        OauthMember saved = oauthMemberRepository.findByOauthId(oauthMember.oauthId())
                .orElseGet(() -> oauthMemberRepository.save(oauthMember));

        return saved.id();
    }

    public String getAuthCodeRequestUrl(OauthServerType oauthServerType){
        return authCodeRequestUrlProviderComposite.provide(oauthServerType);
    }
}
