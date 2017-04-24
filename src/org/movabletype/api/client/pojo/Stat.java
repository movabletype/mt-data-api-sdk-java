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
    "entry",
    "pageviews",
    "author",
    "path",
    "title",
    "archiveType",
    "category",
    "startDate"
})
public class Stat {

    @JsonProperty("entry")
    private Entry entry;
    @JsonProperty("pageviews")
    private String pageviews;
    @JsonProperty("author")
    private Object author;
    @JsonProperty("path")
    private String path;
    @JsonProperty("title")
    private String title;
    @JsonProperty("archiveType")
    private String archiveType;
    @JsonProperty("category")
    private Object category;
    @JsonProperty("startDate")
    private Object startDate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("entry")
    public Entry getEntry() {
        return entry;
    }

    @JsonProperty("entry")
    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    @JsonProperty("pageviews")
    public String getPageviews() {
        return pageviews;
    }

    @JsonProperty("pageviews")
    public void setPageviews(String pageviews) {
        this.pageviews = pageviews;
    }

    @JsonProperty("author")
    public Object getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Object author) {
        this.author = author;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("archiveType")
    public String getArchiveType() {
        return archiveType;
    }

    @JsonProperty("archiveType")
    public void setArchiveType(String archiveType) {
        this.archiveType = archiveType;
    }

    @JsonProperty("category")
    public Object getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(Object category) {
        this.category = category;
    }

    @JsonProperty("startDate")
    public Object getStartDate() {
        return startDate;
    }

    @JsonProperty("startDate")
    public void setStartDate(Object startDate) {
        this.startDate = startDate;
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
