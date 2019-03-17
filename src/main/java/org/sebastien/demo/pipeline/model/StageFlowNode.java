package org.sebastien.demo.pipeline.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StageFlowNode {

    @JsonProperty("_links")
    private Links links;

    @JsonProperty
    private int id;

    @JsonProperty
    private String name;

    @JsonProperty
    private String execNode;

    @JsonProperty
    private String status;

    @JsonProperty
    private long startTimeMillis;

    @JsonProperty
    private long durationMillis;

    @JsonProperty
    private long pauseDurationMillis;

    @JsonProperty
    private String parentNodes;
}
