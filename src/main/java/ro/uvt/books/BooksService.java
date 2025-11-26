package ro.uvt.books;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    private final BooksRepository repository;

    public BooksService(BooksRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        if (repository.count() == 0) {
            Book b = new Book("Noapte buna, copii!");
            b.getAuthors().add("Radu Pavel Gheo");
            repository.save(b);
        }
    }

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    public Book create(Book b) {
        b.setId(null);
        return repository.save(b);
    }

    public Optional<Book> update(Long id, Book b) {
        return repository.findById(id).map(existing -> {
            existing.setTitle(b.getTitle());
            existing.setAuthors(b.getAuthors());
            return repository.save(existing);
        });
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }
}
