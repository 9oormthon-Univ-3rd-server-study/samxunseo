package org.springboot.springstudy.oauth.presentation;

import org.springboot.springstudy.oauth.domain.OauthServerType;
import org.springframework.core.convert.converter.Converter;

public class OauthServerTypeConverter implements Converter<String, OauthServerType> {
    @Override
    public OauthServerType convert(String source){
        return OauthServerType.fromName(source);
    }
}
