package org.sebastien.demo.pipeline.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class DefaultCrumbIssuer {

    @JsonProperty("_class")
    private String crumbClass;

    @JsonProperty
    private String crumb;

    @JsonProperty
    private String crumbRequestField;

}
