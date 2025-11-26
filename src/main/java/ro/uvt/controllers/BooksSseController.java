package ro.uvt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import ro.uvt.observer.AllBooksSubject;
import ro.uvt.observer.SseObserver;

@RestController
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    @Autowired
    public BooksSseController(AllBooksSubject allBooksSubject) {
        this.allBooksSubject = allBooksSubject;
    }

    @RequestMapping("/books-sse")
    public SseEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);
        final ro.uvt.observer.SseObserver obs = new ro.uvt.observer.SseObserver(emitter);
        allBooksSubject.attach(obs);
        // detach observer on completion/timeout/error to avoid memory leaks
        emitter.onCompletion(() -> allBooksSubject.detach(obs));
        emitter.onTimeout(() -> allBooksSubject.detach(obs));
        emitter.onError((ex) -> allBooksSubject.detach(obs));
        return emitter;
    }
}
