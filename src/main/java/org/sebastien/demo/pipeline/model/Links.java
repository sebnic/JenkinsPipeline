package org.sebastien.demo.pipeline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Links {

    @JsonProperty
    private String href;
}
