package ua.kpi.exceptions;

public class ComposerNotFoundException extends RuntimeException {
    public ComposerNotFoundException(Long id) {
        super("Could not find composition " + id);
    }
}
