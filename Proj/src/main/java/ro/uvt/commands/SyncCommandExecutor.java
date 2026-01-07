package ro.uvt.commands;

public class SyncCommandExecutor implements CommandExecutor {
    @Override
    public <T> CommandResult<T> execute(Command<T> cmd) {
        return cmd.execute();
    }

    @Override
    public <T> java.util.UUID submitAsync(Command<T> cmd) {
        throw new UnsupportedOperationException("Async not supported by SyncCommandExecutor");
    }

    @Override
    public CommandResult<?> getStatus(java.util.UUID id) {
        throw new UnsupportedOperationException("No status for sync executor");
    }
}
