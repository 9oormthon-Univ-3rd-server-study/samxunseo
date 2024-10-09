package org.springboot.springstudy.oauth.domain.client;

import org.springboot.springstudy.oauth.domain.OauthMember;
import org.springboot.springstudy.oauth.domain.OauthServerType;

public interface OauthMemberClient {

    OauthServerType supportServer();
    OauthMember fetch(String code);
}
