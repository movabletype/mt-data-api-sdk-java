package org.movabletype.api.client.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "text",
    "blog",
    "customFields",
    "type",
    "createdBy",
    "modifiedDate",
    "updatable",
    "name",
    "linkToFile",
    "createdDate",
    "id",
    "templateType",
    "outputFile",
    "buildType"
})
public class Template {

    @JsonProperty("text")
    private String text;
    @JsonProperty("blog")
    private Blog blog;
    @JsonProperty("customFields")
    private List<CustomField> customFields = null;
    @JsonProperty("type")
    private String type;
    @JsonProperty("createdBy")
    private CreatedBy createdBy;
    @JsonProperty("modifiedDate")
    private String modifiedDate;
    @JsonProperty("updatable")
    private Boolean updatable;
    @JsonProperty("name")
    private String name;
    @JsonProperty("linkToFile")
    private String linkToFile;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("templateType")
    private String templateType;
    @JsonProperty("outputFile")
    private String outputFile;
    @JsonProperty("buildType")
    private String buildType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("blog")
    public Blog getBlog() {
        return blog;
    }

    @JsonProperty("blog")
    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @JsonProperty("customFields")
    public List<CustomField> getCustomFields() {
        return customFields;
    }

    @JsonProperty("customFields")
    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("createdBy")
    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("modifiedDate")
    public String getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("updatable")
    public Boolean getUpdatable() {
        return updatable;
    }

    @JsonProperty("updatable")
    public void setUpdatable(Boolean updatable) {
        this.updatable = updatable;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("linkToFile")
    public String getLinkToFile() {
        return linkToFile;
    }

    @JsonProperty("linkToFile")
    public void setLinkToFile(String linkToFile) {
        this.linkToFile = linkToFile;
    }

    @JsonProperty("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("templateType")
    public String getTemplateType() {
        return templateType;
    }

    @JsonProperty("templateType")
    public void setTemplateType(String templateType) {
        this.templateType = templateType;
    }

    @JsonProperty("outputFile")
    public String getOutputFile() {
        return outputFile;
    }

    @JsonProperty("outputFile")
    public void setOutputFile(String outputFile) {
        this.outputFile = outputFile;
    }

    @JsonProperty("buildType")
    public String getBuildType() {
        return buildType;
    }

    @JsonProperty("buildType")
    public void setBuildType(String buildType) {
        this.buildType = buildType;
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
