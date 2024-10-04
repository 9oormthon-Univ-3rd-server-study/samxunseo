//package org.springboot.springstudy.sse.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.hibernate.annotations.Parameter;
//import org.springboot.springstudy.sse.service.SseService;
//import org.springboot.springstudy.user.domain.UserDetailsImpl;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/sse")
//public class SseController {
//
//    private final SseService sseService;
//    @GetMapping(value = "/subscribe", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
//    public ResponseEntity<SseEmitter> subscribe(@Parameter(hidden = true) @AuthenticationPrincipal UserDetailsImpl userDetails,
//                                                @RequestHeader(value = "Last-Event_ID", required = false, defaultValue = "")String lastEventId){
//        return ResponseEntity.ok(sseService.subscribe(userDetails.getMember()), lastEventId);
//    }
//}