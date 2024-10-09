package org.springboot.springstudy.oauth.presentation;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springboot.springstudy.oauth.domain.OauthServerType;
import org.springboot.springstudy.oauth.service.OauthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/oauth")
public class OauthController {

    private final OauthService oauthService;

    @SneakyThrows // Exception을 따로 던지지 않아도 동작하게 해주는 Annotation -> 남용 금지!!!!
    @GetMapping("/{oauthServerType}")
    ResponseEntity<Void> redirectAuthCodeRequestUrl(@PathVariable OauthServerType oauthServerType,
                                                    HttpServletResponse response){
        String redirectUrl = oauthService.getAuthCodeRequestUrl(oauthServerType);
        response.sendRedirect(redirectUrl);
        log.info(redirectUrl);
        return ResponseEntity.ok().build();
    }
}
