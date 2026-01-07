package ro.uvt.commands;

import ro.uvt.books.Book;
import java.util.List;

public class GetAllBooksCommand implements Command<List<Book>> {
    private final CommandContext ctx;

    public GetAllBooksCommand(CommandContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public CommandResult<List<Book>> execute() {
        try {
            List<Book> books = ctx.getBooksService().findAll();
            return CommandResult.success(books);
        } catch (Exception e) {
            return CommandResult.failed(e.getMessage());
        }
    }
}
