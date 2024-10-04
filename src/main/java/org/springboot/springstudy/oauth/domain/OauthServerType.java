package org.springboot.springstudy.oauth.domain;

import java.util.Locale;

public enum OauthServerType {
    kakao,
    ;

    public static OauthServerType fromName(String type){
        return OauthServerType.valueOf(type.toUpperCase(Locale.ENGLISH));
    }
}
