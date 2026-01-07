package ro.uvt.commands;

import java.util.UUID;

public interface CommandExecutor {
    <T> CommandResult<T> execute(Command<T> cmd);

    <T> UUID submitAsync(Command<T> cmd);

    CommandResult<?> getStatus(UUID id);
}
