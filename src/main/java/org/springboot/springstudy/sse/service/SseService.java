//package org.springboot.springstudy.sse.service;
//
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//@Service
//public class SseService {
//
//    private final SseRepository sseRepository;
//
//    public SseEmitter subscribe(Member member, String lastEventId){
//        String emitterId = member.getUsernam() + "_" + System.currentTimeMillis();
//
//        SseEmitter sseEmitter = sseRepository.save(emitterId, new SseEmitter(DEFAULT_TIMEOUT));
//
//        sseEmitter.onCompletion(() => sseRepository.deleteEmitterById(emitterId);
//        sseEmitter.onTimeout(() => sseRepository.deleteEmitterById(emitterId));
//        sseEmitter.onError(() => sseRepository.deleteEmitterById(emitterId));
//
//        send(sseEmitter, emitterId,createDummyNotification(member.getUsername())));
//
//        if(!lastEventId.isEmpty()){
//            Map<String, Object> eventCaches = sseRepository.findAllEventCacheStartsWithUsername(member.getUsername());
//            eventCaches.entrySet().stream()
//                    .filter(entry -> lastEventId.compareTo(entry.getKey())<0)
//                    .forEach(entry -> emitEventToClient(sseEmitter, entry.getKey(), entry.getValue))
//        }
//
//        return sseEmitter;
//
//    }
//}
