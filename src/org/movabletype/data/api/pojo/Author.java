package org.movabletype.data.api.pojo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "userpicUrl", "displayName" })
public class Author {

    @JsonProperty("userpicUrl")
    private Object userpicUrl;
    @JsonProperty("displayName")
    private String displayName;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("userpicUrl")
    public Object getUserpicUrl() {
        return userpicUrl;
    }

    @JsonProperty("userpicUrl")
    public void setUserpicUrl(Object userpicUrl) {
        this.userpicUrl = userpicUrl;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
