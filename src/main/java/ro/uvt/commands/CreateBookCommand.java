package ro.uvt.commands;

import ro.uvt.books.Book;

public class CreateBookCommand implements Command<Book> {
    private final CommandContext ctx;
    private final Book payload;

    public CreateBookCommand(CommandContext ctx, Book payload) {
        this.ctx = ctx;
        this.payload = payload;
    }

    @Override
    public CommandResult<Book> execute() {
        try {
            Book created = ctx.getBooksService().create(payload);
            return CommandResult.success(created);
        } catch (Exception e) {
            return CommandResult.failed(e.getMessage());
        }
    }
}
