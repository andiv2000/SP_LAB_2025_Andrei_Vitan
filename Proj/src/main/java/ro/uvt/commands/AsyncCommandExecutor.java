package ro.uvt.commands;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AsyncCommandExecutor implements CommandExecutor {
    private final ExecutorService executor = Executors.newFixedThreadPool(4);
    private final Map<UUID, Future<CommandResult<?>>> tasks = new ConcurrentHashMap<>();

    @Override
    public <T> CommandResult<T> execute(Command<T> cmd) {
        // direct synchronous execution
        return cmd.execute();
    }

    @Override
    public <T> UUID submitAsync(Command<T> cmd) {
        UUID id = UUID.randomUUID();
        Future<CommandResult<?>> future = executor.submit(() -> cmd.execute());
        tasks.put(id, future);
        return id;
    }

    @Override
    public CommandResult<?> getStatus(UUID id) {
        Future<CommandResult<?>> f = tasks.get(id);
        if (f == null) return new CommandResult<>(CommandResult.Status.FAILED, null, "Unknown id");
        if (!f.isDone()) return new CommandResult<>(CommandResult.Status.PENDING, null, "Pending");
        try {
            return f.get();
        } catch (Exception e) {
            return CommandResult.failed(e.getMessage());
        }
    }
}
