package ro.uvt.commands;

public class DeleteBookCommand implements Command<Boolean> {
    private final CommandContext ctx;
    private final Long id;

    public DeleteBookCommand(CommandContext ctx, Long id) {
        this.ctx = ctx;
        this.id = id;
    }

    @Override
    public CommandResult<Boolean> execute() {
        try {
            boolean removed = ctx.getBooksService().delete(id);
            return CommandResult.success(removed);
        } catch (Exception e) {
            return CommandResult.failed(e.getMessage());
        }
    }
}
