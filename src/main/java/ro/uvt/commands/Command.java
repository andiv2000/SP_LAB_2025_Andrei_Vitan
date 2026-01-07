package ro.uvt.commands;

public interface Command<T> {
    CommandResult<T> execute();
}
