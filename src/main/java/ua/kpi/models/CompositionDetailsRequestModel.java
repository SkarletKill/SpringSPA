package ua.kpi.models;

import lombok.Data;

@Data
public class CompositionDetailsRequestModel {
    private String name;
    private Long composerId;
    private int duration;
}
