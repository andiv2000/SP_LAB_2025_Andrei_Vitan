package ro.uvt.commands;

import ro.uvt.books.Book;
import java.util.Optional;

public class UpdateBookCommand implements Command<Optional<Book>> {
    private final CommandContext ctx;
    private final Long id;
    private final Book payload;

    public UpdateBookCommand(CommandContext ctx, Long id, Book payload) {
        this.ctx = ctx;
        this.id = id;
        this.payload = payload;
    }

    @Override
    public CommandResult<Optional<Book>> execute() {
        try {
            Optional<Book> updated = ctx.getBooksService().update(id, payload);
            return CommandResult.success(updated);
        } catch (Exception e) {
            return CommandResult.failed(e.getMessage());
        }
    }
}
