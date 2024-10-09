package org.springboot.springstudy.oauth.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OauthMemberRepository extends JpaRepository<OauthMember, Long> {
    Optional<OauthMember> findByOauthId(OauthId oauthId);

}
