package ro.uvt.observer;

import org.springframework.stereotype.Component;
import ro.uvt.books.Book;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class AllBooksSubject implements Subject {
    private final List<Observer> observers = new CopyOnWriteArrayList<>();

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void detach(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Book book) {
        for (Observer o : observers) {
            try {
                o.update(book);
            } catch (Exception e) {
                // observer could have been disconnected; ignore to keep others working
            }
        }
    }

    // convenience method used by application to set new state
    public void add(Book book) {
        notifyObservers(book);
    }
}
