package org.springboot.springstudy.oauth.service;

import lombok.RequiredArgsConstructor;
import org.springboot.springstudy.oauth.domain.OauthServerType;
import org.springboot.springstudy.oauth.domain.authcode.AuthCodeRequestUrlProviderComposite;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OauthService {

    private final AuthCodeRequestUrlProviderComposite authCodeRequestUrlProviderComposite;

    public String getAuthCodeRequestUrl(OauthServerType oauthServerType){
        return authCodeRequestUrlProviderComposite.provide(oauthServerType);
    }
}
