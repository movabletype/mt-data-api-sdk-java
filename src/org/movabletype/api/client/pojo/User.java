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
@JsonPropertyOrder({ "status", "createdBy", "updatable", "lockedOut", "isSuperuser", "dateFormat", "systemPermissions", "email", "userpicUrl", "url", "id",
        "tagDelimiter", "displayName", "modifiedBy", "modifiedDate", "language", "name", "textFormat", "createdDate", "customFields", "password", "apiPassword" })
public class User {

    @JsonProperty("status")
    private String status;
    @JsonProperty("createdBy")
    private CreatedBy createdBy;
    @JsonProperty("updatable")
    private Boolean updatable;
    @JsonProperty("lockedOut")
    private Boolean lockedOut;
    @JsonProperty("isSuperuser")
    private Boolean isSuperuser;
    @JsonProperty("dateFormat")
    private String dateFormat;
    @JsonProperty("systemPermissions")
    private List<String> systemPermissions = null;
    @JsonProperty("email")
    private String email;
    @JsonProperty("userpicUrl")
    private String userpicUrl;
    @JsonProperty("url")
    private String url;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("tagDelimiter")
    private String tagDelimiter;
    @JsonProperty("displayName")
    private String displayName;
    @JsonProperty("modifiedBy")
    private ModifiedBy modifiedBy;
    @JsonProperty("modifiedDate")
    private String modifiedDate;
    @JsonProperty("language")
    private String language;
    @JsonProperty("name")
    private String name;
    @JsonProperty("textFormat")
    private String textFormat;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("customFields")
    private List<CustomField> customFields = null;
    @JsonProperty("password")
    private String password;
    @JsonProperty("apiPassword")
    private String apiPassword;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("status")
    public String getStatus() {
        return status;
    }

    /**
     * @param status UserStatus.ACTIVE, UserStatus.PENDING...
     */
    @JsonProperty("status")
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty("createdBy")
    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("updatable")
    public Boolean getUpdatable() {
        return updatable;
    }

    @JsonProperty("updatable")
    public void setUpdatable(Boolean updatable) {
        this.updatable = updatable;
    }

    @JsonProperty("lockedOut")
    public Boolean getLockedOut() {
        return lockedOut;
    }

    @JsonProperty("lockedOut")
    public void setLockedOut(Boolean lockedOut) {
        this.lockedOut = lockedOut;
    }

    @JsonProperty("isSuperuser")
    public Boolean getIsSuperuser() {
        return isSuperuser;
    }

    @JsonProperty("isSuperuser")
    public void setIsSuperuser(Boolean isSuperuser) {
        this.isSuperuser = isSuperuser;
    }

    @JsonProperty("dateFormat")
    public String getDateFormat() {
        return dateFormat;
    }

    @JsonProperty("dateFormat")
    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @JsonProperty("systemPermissions")
    public List<String> getSystemPermissions() {
        return systemPermissions;
    }

    @JsonProperty("systemPermissions")
    public void setSystemPermissions(List<String> systemPermissions) {
        this.systemPermissions = systemPermissions;
    }

    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("userpicUrl")
    public String getUserpicUrl() {
        return userpicUrl;
    }

    @JsonProperty("userpicUrl")
    public void setUserpicUrl(String userpicUrl) {
        this.userpicUrl = userpicUrl;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("tagDelimiter")
    public String getTagDelimiter() {
        return tagDelimiter;
    }

    /**
     * @param tagDelimiter TagDelimiter.COMMA, TagDelimiter.SPACE
     */
    @JsonProperty("tagDelimiter")
    public void setTagDelimiter(String tagDelimiter) {
        this.tagDelimiter = tagDelimiter;
    }

    @JsonProperty("displayName")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("displayName")
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
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

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    /**
     * @param language Language.JA, Language.EN_US ...
     */
    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("textFormat")
    public String getTextFormat() {
        return textFormat;
    }

    @JsonProperty("textFormat")
    public void setTextFormat(String textFormat) {
        this.textFormat = textFormat;
    }

    @JsonProperty("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("customFields")
    public List<CustomField> getCustomFields() {
        return customFields;
    }

    @JsonProperty("customFields")
    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }
    
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    @JsonProperty("apiPassword")
    public String getApiPassword() {
        return apiPassword;
    }

    @JsonProperty("apiPassword")
    public void setApiPassword(String apiPassword) {
        this.apiPassword = apiPassword;
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
