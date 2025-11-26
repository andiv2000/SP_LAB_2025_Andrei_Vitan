package ro.uvt.observer;

import ro.uvt.books.Book;

public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyObservers(Book book);
}
