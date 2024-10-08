package org.springboot.springstudy.oauth.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "oauth_member",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "oauth_id_unique",
                        columnNames = {
                                "oauth_server_id",
                                "oauth_server"
                        }
                ),
        }
)
public class OauthMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded // from OauthId
    private OauthId oauthId;

    private String nickname;
    private String profileImageUrl;

    public Long id(){
        return id;
    }

    public OauthId oauthId(){
        return oauthId;
    }

    public String nickname(){
        return nickname;
    }

    public String profileImageUrl(){
        return profileImageUrl;
    }

}
