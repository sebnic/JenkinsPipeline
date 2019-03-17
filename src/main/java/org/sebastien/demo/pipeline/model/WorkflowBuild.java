package org.sebastien.demo.pipeline.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class WorkflowBuild {

    @JsonProperty("_links")
    private Links links;

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String status;

    @JsonProperty
    private long startTimeMillis;

    @JsonProperty
    private long endTimeMillis;

    @JsonProperty
    private long durationMillis;

    @JsonProperty
    private long queueDurationMillis;

    @JsonProperty
    private long pauseDurationMillis;

    @JsonProperty
    private List<Stage> stages;
}
