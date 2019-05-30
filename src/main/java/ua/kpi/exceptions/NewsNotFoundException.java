package ua.kpi.exceptions;

public class NewsNotFoundException extends  RuntimeException {
    public NewsNotFoundException(Long id) {
        super("Could not find news " + id);
    }
}
