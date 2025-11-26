package ro.uvt.commands;

public class CommandResult<T> {
    public enum Status { PENDING, SUCCESS, FAILED }

    private final Status status;
    private final T payload;
    private final String message;

    public CommandResult(Status status, T payload, String message) {
        this.status = status;
        this.payload = payload;
        this.message = message;
    }

    public Status getStatus() { return status; }
    public T getPayload() { return payload; }
    public String getMessage() { return message; }

    public static <T> CommandResult<T> success(T payload) {
        return new CommandResult<>(Status.SUCCESS, payload, null);
    }

    public static <T> CommandResult<T> failed(String message) {
        return new CommandResult<>(Status.FAILED, null, message);
    }
}
