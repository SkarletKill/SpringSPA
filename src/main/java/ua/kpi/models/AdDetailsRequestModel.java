package ua.kpi.models;

import lombok.Data;

@Data
public class AdDetailsRequestModel {
    private String title;
    private String text;
    private long compositionId;
}
