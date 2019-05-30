package ua.kpi.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Statistics {
    private long compositionCount;
    private long composerCount;
    private long newsCount;
    private long adCount;
}
