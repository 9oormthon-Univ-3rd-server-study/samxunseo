package org.springboot.springstudy.oauth.domain.authcode;

import org.springboot.springstudy.oauth.domain.OauthServerType;

public interface AuthCodeRequestUrlProvider {
    OauthServerType supportServer();
    String provide();
}
