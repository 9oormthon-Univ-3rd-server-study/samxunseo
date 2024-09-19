package org.springboot.springstudy.sse.controller;

import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.springboot.springstudy.sse.domain.SseEmitters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@Slf4j
public class SseController {

    private final SseEmitters sseEmitters;

    @Autowired
    public SseController(SseEmitters sseEmitters) {
        this.sseEmitters = sseEmitters;
    }

    // SSE 연결을 설정하는 엔드포인트
    @GetMapping(value = "/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<SseEmitter> connect() {
        // 새로운 SseEmitter 인스턴스 생성
        SseEmitter emitter = new SseEmitter();
        // SseEmitters 컬렉션에 새 emitter 추가
        sseEmitters.add(emitter);
        try {
            // 클라이언트에게 연결 성공 메시지 전송
            emitter.send(SseEmitter.event()
                    .name("connect")
                    .data("connected!"));
        } catch (IOException e) {
            log.error("Error while sending connect event", e);
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(emitter);
    }

    // 카운트를 증가시키고 모든 연결된 클라이언트에게 새 카운트를 전송하는 엔드포인트
    @PostMapping("/count")
    public ResponseEntity<Void> count() {
        // SseEmitters의 count 메서드 호출하여 카운트 증가 및 전송
        sseEmitters.count();
        return ResponseEntity.ok().build();
    }
}