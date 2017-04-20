package org.movabletype.api.client.pojo;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ 
    "authorName",
    "authorLink",
    "version",
    "description",
    "uninstallable",
    "inUse",
    "id",
    "label",
    "current" })

public class Theme {

    @JsonProperty("authorName")
    private String authorName;
    @JsonProperty("authorLink")
    private String authorLink;
    @JsonProperty("version")
    private String version;
    @JsonProperty("description")
    private String description;
    @JsonProperty("uninstallable")
    private Boolean uninstallable;
    @JsonProperty("inUse")
    private Boolean inUse;
    @JsonProperty("id")
    private String id;
    @JsonProperty("label")
    private String label;
    @JsonProperty("current")
    private Boolean current;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("authorName")
    public String getAuthorName() {
        return authorName;
    }

    @JsonProperty("authorName")
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    @JsonProperty("authorLink")
    public String getAuthorLink() {
        return authorLink;
    }

    @JsonProperty("authorLink")
    public void setAuthorLink(String authorLink) {
        this.authorLink = authorLink;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("uninstallable")
    public Boolean getUninstallable() {
        return uninstallable;
    }

    @JsonProperty("uninstallable")
    public void setUninstallable(Boolean uninstallable) {
        this.uninstallable = uninstallable;
    }

    @JsonProperty("inUse")
    public Boolean getInUse() {
        return inUse;
    }

    @JsonProperty("inUse")
    public void setInUse(Boolean inUse) {
        this.inUse = inUse;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    @JsonProperty("current")
    public Boolean getCurrent() {
        return current;
    }

    @JsonProperty("current")
    public void setCurrent(Boolean current) {
        this.current = current;
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
