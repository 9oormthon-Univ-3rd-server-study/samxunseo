//package org.springboot.springstudy.oauth.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springboot.springstudy.oauth.dto.GoogleUserInfoResponse;
//import org.springboot.springstudy.oauth.dto.KakaoUserInfoResponse;
//import org.springboot.springstudy.oauth.service.OAuthService;
//import org.springboot.springstudy.user.dto.response.TokenResponse;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.util.UriComponentsBuilder;
//
//@RestController
//@RequestMapping("/oauth")
//@RequiredArgsConstructor
//public class OAuthController {
//    private final WebClient webClient;
//    private final OAuthService oAuthService;
//
//    @Value("${spring.oauth.kakao.client_id}")
//    private String kakaoClientId;
//
//    @Value("${spring.oauth.google.client_id}")
//    private String googleClientId;
//
//    @Value("${spring.oauth.google.client_password}")
//    private String googleClientPassword;
//
//    @GetMapping("/kakao")
//    public TokenResponse kakaoLogin(@RequestParam String code){
//        String requestUri = UriComponentsBuilder.fromHttpUrl("https://kauth.kakao.com/oauth/token")
//                .queryParam("grant_type", "authorization_code")
//                .queryParam("client_id", kakaoClientId)
//                .queryParam("redirect_uri", "http://localhost:8080/oauth/kakao")
//                .queryParam("code", code)
//                .toUriString();
//
//        TokenResponse tokenResponse = webClient.post()
//                .uri(requestUri)
//                .retrieve()
//                .bodyToMono(TokenResponse.class)
//                .block();
//
//        KakaoUserInfoResponse response = webClient.post()
//                .uri("https://kapi.kakao.com/v2/user/me")
//                .header("Authorization", "Bearer " + tokenResponse.accessToken())
//                .retrieve()
//                .bodyToMono(KakaoUserInfoResponse.class)
//                .block();
//
//        return oAuthService.register(response.getKakao_account().getEmail());
//    }
//
//    @GetMapping("/google")
//    public TokenResponse googleLogin(@RequestParam String code) {
//
//        String requestUri = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/token")
//                .queryParam("code", code)
//                .queryParam("client_id", googleClientId)
//                .queryParam("client_secret", googleClientPassword)
//                .queryParam("redirect_uri", "http://localhost:8080/oauth/google")
//                .queryParam("grant_type", "authorization_code")
//                .toUriString();
//
//        TokenResponse tokenResponse = webClient.post()
//                .uri(requestUri)
//                .retrieve()
//                .bodyToMono(TokenResponse.class)
//                .block();
//
//        GoogleUserInfoResponse response = webClient.post()
//                .uri("https://oauth2.googleapis.com/tokeninfo?access_token=" + tokenResponse.accessToken())
//                .retrieve()
//                .bodyToMono(GoogleUserInfoResponse.class)
//                .block();
//
//        return oAuthService.register(response.email());
//    }
//}
