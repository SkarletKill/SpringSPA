package ua.kpi.exceptions;

public class CompositionNotFoundException extends RuntimeException {
    public CompositionNotFoundException(Long id) {
        super("Could not find composition " + id);
    }
}
