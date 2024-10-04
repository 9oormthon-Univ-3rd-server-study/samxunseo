//package org.springboot.springstudy.sse.domain;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//import java.io.IOException;
//import java.util.List;
//import java.util.concurrent.CopyOnWriteArrayList;
//import java.util.concurrent.atomic.AtomicLong;
//
//@Component
//@Slf4j
//public class SseEmitters {
//    // 카운트를 위한 AtomicLong 변수
//    private static final AtomicLong counter = new AtomicLong();
//
//    // 스레드 안전한 리스트를 사용하여 SseEmitter 객체들을 관리
//    private final List<SseEmitter> emitters = new CopyOnWriteArrayList<>();
//
//    // 새로운 SseEmitter를 리스트에 추가하고 콜백 설정
//    public SseEmitter add(SseEmitter emitter) {
//        this.emitters.add(emitter);
//        log.info("New emitter added: {}", emitter);
//        log.info("Emitter list size: {}", emitters.size());
//
//        // 완료 콜백 설정
//        emitter.onCompletion(() -> {
//            log.info("onCompletion callback");
//            removeEmitter(emitter);
//        });
//
//        // 타임아웃 콜백 설정
//        emitter.onTimeout(() -> {
//            log.info("onTimeout callback");
//            removeEmitter(emitter);
//        });
//
//        return emitter;
//    }
//
//    // SseEmitter를 리스트에서 제거
//    private void removeEmitter(SseEmitter emitter) {
//        boolean removed = this.emitters.remove(emitter);
//        if (removed) {
//            log.info("Emitter removed, current size: {}", emitters.size());
//        }
//    }
//
//    // 카운트를 증가시키고 모든 연결된 클라이언트에게 새 카운트를 전송
//    public void count() {
//        long count = counter.incrementAndGet();
//        emitters.forEach(emitter -> {
//            try {
//                emitter.send(SseEmitter.event()
//                        .name("count")
//                        .data(count));
//            } catch (IOException e) {
//                log.error("Error while sending count event", e);
//                removeEmitter(emitter);
//            }
//        });
//    }
//}