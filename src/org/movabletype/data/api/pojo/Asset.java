package org.movabletype.data.api.pojo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "label", "mimeType", "url", "filename", "description", "tags", "blog", "updatable", "modifiedBy", "modifiedDate", "createdBy",
        "cratedDate", "type", "class", "fileExt", "parent", "meta" })
public class Asset {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("label")
    private String label;
    @JsonProperty("mimeType")
    private String mimeType;
    @JsonProperty("url")
    private String url;
    @JsonProperty("filename")
    private String filename;
    @JsonProperty("description")
    private String description;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("blog")
    private Blog blog;
    @JsonProperty("updatable")
    private Boolean updatable;
    @JsonProperty("modifiedBy")
    private ModifiedBy modifiedBy;
    @JsonProperty("modifiedDate")
    private String modifiedDate;
    @JsonProperty("createdBy")
    private CreatedBy createdBy;
    @JsonProperty("cratedDate")
    private String cratedDate;
    @JsonProperty("type")
    private String type;
    @JsonProperty("class")
    private String _class;
    @JsonProperty("fileExt")
    private String fileExt;
    @JsonProperty("parent")
    private Parent parent;
    @JsonProperty("meta")
    private Meta meta;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
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

    @JsonProperty("mimeType")
    public String getMimeType() {
        return mimeType;
    }

    @JsonProperty("mimeType")
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("filename")
    public String getFilename() {
        return filename;
    }

    @JsonProperty("filename")
    public void setFilename(String filename) {
        this.filename = filename;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("blog")
    public Blog getBlog() {
        return blog;
    }

    @JsonProperty("blog")
    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @JsonProperty("updatable")
    public Boolean getUpdatable() {
        return updatable;
    }

    @JsonProperty("updatable")
    public void setUpdatable(Boolean updatable) {
        this.updatable = updatable;
    }

    @JsonProperty("modifiedBy")
    public ModifiedBy getModifiedBy() {
        return modifiedBy;
    }

    @JsonProperty("modifiedBy")
    public void setModifiedBy(ModifiedBy modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonProperty("modifiedDate")
    public String getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("createdBy")
    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("cratedDate")
    public String getCratedDate() {
        return cratedDate;
    }

    @JsonProperty("cratedDate")
    public void setCratedDate(String cratedDate) {
        this.cratedDate = cratedDate;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonProperty("fileExt")
    public String getFileExt() {
        return fileExt;
    }

    @JsonProperty("fileExt")
    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    @JsonProperty("parent")
    public Parent getParent() {
        return parent;
    }

    @JsonProperty("parent")
    public void setParent(Parent parent) {
        this.parent = parent;
    }

    @JsonProperty("meta")
    public Meta getMeta() {
        return meta;
    }

    @JsonProperty("meta")
    public void setMeta(Meta meta) {
        this.meta = meta;
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
