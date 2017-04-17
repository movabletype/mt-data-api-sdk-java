package org.movabletype.api.client.pojo;

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
@JsonPropertyOrder({ "excerpt", "status", "date", "updatable", "author", "allowComments", "comments", "permalink", "body", "keywords", "allowTrackbacks", "id",
        "trackbacks", "modifiedDate", "trackbackCount", "categories", "blog", "commentCount", "tags", "basename", "assets", "pingsSentUrl", "title", "class",
        "createdDate", "more", "format", "unpublishedDate", "customFields" })
public class Entry {

    @JsonProperty("excerpt")
    private String excerpt;
    @JsonProperty("status")
    private String status;
    @JsonProperty("date")
    private String date;
    @JsonProperty("updatable")
    private Boolean updatable;
    @JsonProperty("author")
    private Author author;
    @JsonProperty("allowComments")
    private Boolean allowComments;
    @JsonProperty("comments")
    private List<Comment> comments = null;
    @JsonProperty("permalink")
    private String permalink;
    @JsonProperty("body")
    private String body;
    @JsonProperty("keywords")
    private String keywords;
    @JsonProperty("allowTrackbacks")
    private Boolean allowTrackbacks;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("trackbacks")
    private List<Trackback> trackbacks = null;
    @JsonProperty("modifiedDate")
    private String modifiedDate;
    @JsonProperty("trackbackCount")
    private String trackbackCount;
    @JsonProperty("categories")
    private List<Category> categories = null;
    @JsonProperty("blog")
    private Blog blog;
    @JsonProperty("commentCount")
    private String commentCount;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("basename")
    private String basename;
    @JsonProperty("assets")
    private List<Asset> assets = null;
    @JsonProperty("pingsSentUrl")
    private List<String> pingsSentUrl = null;
    @JsonProperty("title")
    private String title;
    @JsonProperty("class")
    private String _class;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("more")
    private String more;
    @JsonProperty("format")
    private String format;
    @JsonProperty("unpublishedDate")
    private String unpublishedDate;
    @JsonProperty("customFields")
    private List<CustomField> customFields = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("excerpt")
    public String getExcerpt() {
        return excerpt;
    }

    @JsonProperty("excerpt")
    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("updatable")
    public Boolean getUpdatable() {
        return updatable;
    }

    @JsonProperty("updatable")
    public void setUpdatable(Boolean updatable) {
        this.updatable = updatable;
    }

    @JsonProperty("author")
    public Author getAuthor() {
        return author;
    }

    @JsonProperty("author")
    public void setAuthor(Author author) {
        this.author = author;
    }

    @JsonProperty("allowComments")
    public Boolean getAllowComments() {
        return allowComments;
    }

    @JsonProperty("allowComments")
    public void setAllowComments(Boolean allowComments) {
        this.allowComments = allowComments;
    }

    @JsonProperty("comments")
    public List<Comment> getComments() {
        return comments;
    }

    @JsonProperty("comments")
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @JsonProperty("permalink")
    public String getPermalink() {
        return permalink;
    }

    @JsonProperty("permalink")
    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @JsonProperty("body")
    public void setBody(String body) {
        this.body = body;
    }

    @JsonProperty("keywords")
    public String getKeywords() {
        return keywords;
    }

    @JsonProperty("keywords")
    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    @JsonProperty("allowTrackbacks")
    public Boolean getAllowTrackbacks() {
        return allowTrackbacks;
    }

    @JsonProperty("allowTrackbacks")
    public void setAllowTrackbacks(Boolean allowTrackbacks) {
        this.allowTrackbacks = allowTrackbacks;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("trackbacks")
    public List<Trackback> getTrackbacks() {
        return trackbacks;
    }

    @JsonProperty("trackbacks")
    public void setTrackbacks(List<Trackback> trackbacks) {
        this.trackbacks = trackbacks;
    }

    @JsonProperty("modifiedDate")
    public String getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("trackbackCount")
    public String getTrackbackCount() {
        return trackbackCount;
    }

    @JsonProperty("trackbackCount")
    public void setTrackbackCount(String trackbackCount) {
        this.trackbackCount = trackbackCount;
    }

    @JsonProperty("categories")
    public List<Category> getCategories() {
        return categories;
    }

    @JsonProperty("categories")
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @JsonProperty("blog")
    public Blog getBlog() {
        return blog;
    }

    @JsonProperty("blog")
    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @JsonProperty("commentCount")
    public String getCommentCount() {
        return commentCount;
    }

    @JsonProperty("commentCount")
    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("basename")
    public String getBasename() {
        return basename;
    }

    @JsonProperty("basename")
    public void setBasename(String basename) {
        this.basename = basename;
    }

    @JsonProperty("assets")
    public List<Asset> getAssets() {
        return assets;
    }

    @JsonProperty("assets")
    public void setAssets(List<Asset> assets) {
        this.assets = assets;
    }

    @JsonProperty("pingsSentUrl")
    public List<String> getPingsSentUrl() {
        return pingsSentUrl;
    }

    @JsonProperty("pingsSentUrl")
    public void setPingsSentUrl(List<String> pingsSentUrl) {
        this.pingsSentUrl = pingsSentUrl;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonProperty("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("more")
    public String getMore() {
        return more;
    }

    @JsonProperty("more")
    public void setMore(String more) {
        this.more = more;
    }
    
    @JsonProperty("format")
    public String getFormat() {
        return format;
    }

    @JsonProperty("format")
    public void setFormat(String format) {
        this.format = format;
    }
    
    @JsonProperty("unpublishedDate")
    public String getUnpublishedDate() {
        return unpublishedDate;
    }

    @JsonProperty("unpublishedDate")
    public void setUnpublishedDate(String unpublishedDate) {
        this.unpublishedDate = unpublishedDate;
    }

    @JsonProperty("customFields")
    public List<CustomField> getCustomFields() {
        return customFields;
    }

    @JsonProperty("customFields")
    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
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
