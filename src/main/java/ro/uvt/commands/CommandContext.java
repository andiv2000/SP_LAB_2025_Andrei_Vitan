package ro.uvt.commands;

import ro.uvt.books.BooksService;

public class CommandContext {
    private final BooksService booksService;

    public CommandContext(BooksService booksService) {
        this.booksService = booksService;
    }

    public BooksService getBooksService() { return booksService; }
}
