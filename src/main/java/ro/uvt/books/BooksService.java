package ro.uvt.books;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class BooksService {
    private final Map<Long, Book> storage = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public BooksService() {
        // preload with sample
        Book b = new Book(idGen.getAndIncrement(), "Noapte buna, copii!");
        b.getAuthors().add("Radu Pavel Gheo");
        storage.put(b.getId(), b);
    }

    public List<Book> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Book create(Book b) {
        Long id = idGen.getAndIncrement();
        b.setId(id);
        storage.put(id, b);
        return b;
    }

    public Optional<Book> update(Long id, Book b) {
        if (!storage.containsKey(id)) return Optional.empty();
        b.setId(id);
        storage.put(id, b);
        return Optional.of(b);
    }

    public boolean delete(Long id) {
        return storage.remove(id) != null;
    }
}
