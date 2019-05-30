package ua.kpi.exceptions;

public class AdNotFoundException extends RuntimeException {
    public AdNotFoundException(Long id)  {
        super("Could not find ad " + id);
    }
}
