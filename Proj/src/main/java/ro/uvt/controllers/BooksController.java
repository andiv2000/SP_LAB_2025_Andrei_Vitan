package ro.uvt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.uvt.books.Book;
import ro.uvt.books.BooksService;
import ro.uvt.commands.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final BooksService booksService;
    private final CommandExecutor syncExecutor;
    private final CommandExecutor asyncExecutor;

    @Autowired
    public BooksController(BooksService booksService) {
        this.booksService = booksService;
        this.syncExecutor = new SyncCommandExecutor();
        this.asyncExecutor = new AsyncCommandExecutor();
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        CommandContext ctx = new CommandContext(booksService);
        GetAllBooksCommand cmd = new GetAllBooksCommand(ctx);
        CommandResult<List<Book>> res = syncExecutor.execute(cmd);
        if (res.getStatus() == CommandResult.Status.SUCCESS) return ResponseEntity.ok(res.getPayload());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res.getMessage());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        CommandContext ctx = new CommandContext(booksService);
        GetBookByIdCommand cmd = new GetBookByIdCommand(ctx, id);
        CommandResult<Optional<Book>> res = syncExecutor.execute(cmd);
        if (res.getStatus() == CommandResult.Status.SUCCESS) return res.getPayload().map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res.getMessage());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Book book) {
        CommandContext ctx = new CommandContext(booksService);
        CreateBookCommand cmd = new CreateBookCommand(ctx, book);
        // for demo we process POST asynchronously (e.g., external ISBN service)
        UUID opId = asyncExecutor.submitAsync(cmd);
        return ResponseEntity.accepted().header("Operation-Id", opId.toString()).body("Accepted: " + opId);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Book book) {
        CommandContext ctx = new CommandContext(booksService);
        UpdateBookCommand cmd = new UpdateBookCommand(ctx, id, book);
        CommandResult<Optional<Book>> res = syncExecutor.execute(cmd);
        if (res.getStatus() == CommandResult.Status.SUCCESS) return res.getPayload().map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res.getMessage());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        CommandContext ctx = new CommandContext(booksService);
        DeleteBookCommand cmd = new DeleteBookCommand(ctx, id);
        CommandResult<Boolean> res = syncExecutor.execute(cmd);
        if (res.getStatus() == CommandResult.Status.SUCCESS) {
            if (Boolean.TRUE.equals(res.getPayload())) return ResponseEntity.noContent().build();
            else return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(res.getMessage());
    }

    @GetMapping("/operations/{opId}")
    public ResponseEntity<?> getOperationStatus(@PathVariable String opId) {
        try {
            UUID id = UUID.fromString(opId);
            CommandResult<?> status = asyncExecutor.getStatus(id);
            return ResponseEntity.ok(status.getStatus().name());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid id");
        }
    }
}
