package ro.uvt.commands;

import ro.uvt.books.Book;
import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {
    private final CommandContext ctx;
    private final Long id;

    public GetBookByIdCommand(CommandContext ctx, Long id) {
        this.ctx = ctx;
        this.id = id;
    }

    @Override
    public CommandResult<Optional<Book>> execute() {
        try {
            Optional<Book> book = ctx.getBooksService().findById(id);
            return CommandResult.success(book);
        } catch (Exception e) {
            return CommandResult.failed(e.getMessage());
        }
    }
}
