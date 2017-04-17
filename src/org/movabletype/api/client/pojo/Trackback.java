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
    "title",
    "excerpt",
    "blogName",
    "createdDate",
    "blog",
    "date",
    "status",
    "customFields",
    "ip",
    "url",
    "modifiedDate",
    "entry",
    "id",
    "updatable"
})
public class Trackback {

    @JsonProperty("title")
    private String title;
    @JsonProperty("excerpt")
    private String excerpt;
    @JsonProperty("blogName")
    private String blogName;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("blog")
    private Blog blog;
    @JsonProperty("date")
    private String date;
    @JsonProperty("status")
    private String status;
    @JsonProperty("customFields")
    private List<Object> customFields = null;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("url")
    private String url;
    @JsonProperty("modifiedDate")
    private String modifiedDate;
    @JsonProperty("entry")
    private Entry entry;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("updatable")
    private Boolean updatable;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("excerpt")
    public String getExcerpt() {
        return excerpt;
    }

    @JsonProperty("excerpt")
    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    @JsonProperty("blogName")
    public String getBlogName() {
        return blogName;
    }

    @JsonProperty("blogName")
    public void setBlogName(String blogName) {
        this.blogName = blogName;
    }

    @JsonProperty("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("blog")
    public Blog getBlog() {
        return blog;
    }

    @JsonProperty("blog")
    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("customFields")
    public List<Object> getCustomFields() {
        return customFields;
    }

    @JsonProperty("customFields")
    public void setCustomFields(List<Object> customFields) {
        this.customFields = customFields;
    }

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("modifiedDate")
    public String getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("entry")
    public Entry getEntry() {
        return entry;
    }

    @JsonProperty("entry")
    public void setEntry(Entry entry) {
        this.entry = entry;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("updatable")
    public Boolean getUpdatable() {
        return updatable;
    }

    @JsonProperty("updatable")
    public void setUpdatable(Boolean updatable) {
        this.updatable = updatable;
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
