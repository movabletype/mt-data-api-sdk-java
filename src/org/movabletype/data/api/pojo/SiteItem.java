package org.movabletype.data.api.pojo;

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
@JsonPropertyOrder({ "serverOffset", "themeId", "statusDefault", "autodiscoverLinks", "useRevision", "relativeUrl", "entryCustomPrefs", "archivePath",
        "useCommentConfirmation", "url", "smartReplaceFields", "modifiedBy", "operationIfExists", "timezone", "daysOrPosts", "sortOrderPosts", "name",
        "convertParas", "description", "autoRenameNonAscii", "includeSystem", "archiveUrl", "allowCommentHtml", "fileExtension", "smartReplace",
        "junkFolderExpiry", "publishEmptyArchive", "dateLanguage", "listOnIndex", "pingWeblogs", "extraPath", "normalizeOrientation", "emailNewComments",
        "language", "autolinkUrls", "sanitizeSpec", "customFields", "emailNewPings", "nofollowUrls", "createdBy", "pingGoogle", "convertParasComments",
        "sitePath", "id", "parent", "archiveTypePreferred", "contentCss", "junkScoreThreshold", "internalAutodiscovery", "createdDate", "class",
        "moderateComments", "allowCommentsDefault", "includeCache", "allowCommenterRegist", "allowToChangeAtUpload", "uploadDestination", "maxRevisionsEntry",
        "updatable", "requireCommentEmails", "ccLicenseImage", "allowComments", "allowPingsDefault", "pingOthers", "basenameLimit", "dynamicCache",
        "modifiedDate", "allowPings", "pageCustomPrefs", "dynamicConditional", "commenterAuthenticators", "host", "ccLicenseUrl", "newCreatedUserRoles",
        "wordsInExcerpt", "sortOrderComments", "followAuthLinks", "allowUnregComments", "maxRevisionsTemplate", "moderatePings", "customDynamicTemplates" })
public class SiteItem {

    @JsonProperty("serverOffset")
    private String serverOffset;
    @JsonProperty("themeId")
    private String themeId;
    @JsonProperty("statusDefault")
    private String statusDefault;
    @JsonProperty("autodiscoverLinks")
    private Boolean autodiscoverLinks;
    @JsonProperty("useRevision")
    private Boolean useRevision;
    @JsonProperty("relativeUrl")
    private String relativeUrl;
    @JsonProperty("entryCustomPrefs")
    private List<String> entryCustomPrefs = null;
    @JsonProperty("archivePath")
    private String archivePath;
    @JsonProperty("useCommentConfirmation")
    private Boolean useCommentConfirmation;
    @JsonProperty("url")
    private String url;
    @JsonProperty("smartReplaceFields")
    private List<String> smartReplaceFields = null;
    @JsonProperty("modifiedBy")
    private ModifiedBy modifiedBy;
    @JsonProperty("operationIfExists")
    private String operationIfExists;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("daysOrPosts")
    private String daysOrPosts;
    @JsonProperty("sortOrderPosts")
    private String sortOrderPosts;
    @JsonProperty("name")
    private String name;
    @JsonProperty("convertParas")
    private String convertParas;
    @JsonProperty("description")
    private String description;
    @JsonProperty("autoRenameNonAscii")
    private Boolean autoRenameNonAscii;
    @JsonProperty("includeSystem")
    private String includeSystem;
    @JsonProperty("archiveUrl")
    private String archiveUrl;
    @JsonProperty("allowCommentHtml")
    private Boolean allowCommentHtml;
    @JsonProperty("fileExtension")
    private String fileExtension;
    @JsonProperty("smartReplace")
    private Integer smartReplace;
    @JsonProperty("junkFolderExpiry")
    private String junkFolderExpiry;
    @JsonProperty("publishEmptyArchive")
    private Boolean publishEmptyArchive;
    @JsonProperty("dateLanguage")
    private String dateLanguage;
    @JsonProperty("listOnIndex")
    private String listOnIndex;
    @JsonProperty("pingWeblogs")
    private Boolean pingWeblogs;
    @JsonProperty("extraPath")
    private String extraPath;
    @JsonProperty("normalizeOrientation")
    private Boolean normalizeOrientation;
    @JsonProperty("emailNewComments")
    private String emailNewComments;
    @JsonProperty("language")
    private String language;
    @JsonProperty("autolinkUrls")
    private Boolean autolinkUrls;
    @JsonProperty("sanitizeSpec")
    private String sanitizeSpec;
    @JsonProperty("customFields")
    private List<Object> customFields = null;
    @JsonProperty("emailNewPings")
    private String emailNewPings;
    @JsonProperty("nofollowUrls")
    private Boolean nofollowUrls;
    @JsonProperty("createdBy")
    private CreatedBy createdBy;
    @JsonProperty("pingGoogle")
    private Boolean pingGoogle;
    @JsonProperty("convertParasComments")
    private String convertParasComments;
    @JsonProperty("sitePath")
    private String sitePath;
    @JsonProperty("id")
    private String id;
    @JsonProperty("parent")
    private Object parent;
    @JsonProperty("archiveTypePreferred")
    private String archiveTypePreferred;
    @JsonProperty("contentCss")
    private String contentCss;
    @JsonProperty("junkScoreThreshold")
    private String junkScoreThreshold;
    @JsonProperty("internalAutodiscovery")
    private Boolean internalAutodiscovery;
    @JsonProperty("createdDate")
    private String createdDate;
    @JsonProperty("class")
    private String _class;
    @JsonProperty("moderateComments")
    private String moderateComments;
    @JsonProperty("allowCommentsDefault")
    private Boolean allowCommentsDefault;
    @JsonProperty("includeCache")
    private Boolean includeCache;
    @JsonProperty("allowCommenterRegist")
    private Boolean allowCommenterRegist;
    @JsonProperty("allowToChangeAtUpload")
    private Boolean allowToChangeAtUpload;
    @JsonProperty("uploadDestination")
    private UploadDestination uploadDestination;
    @JsonProperty("maxRevisionsEntry")
    private String maxRevisionsEntry;
    @JsonProperty("updatable")
    private Boolean updatable;
    @JsonProperty("requireCommentEmails")
    private Boolean requireCommentEmails;
    @JsonProperty("ccLicenseImage")
    private String ccLicenseImage;
    @JsonProperty("allowComments")
    private Boolean allowComments;
    @JsonProperty("allowPingsDefault")
    private Boolean allowPingsDefault;
    @JsonProperty("pingOthers")
    private List<Object> pingOthers = null;
    @JsonProperty("basenameLimit")
    private String basenameLimit;
    @JsonProperty("dynamicCache")
    private Boolean dynamicCache;
    @JsonProperty("modifiedDate")
    private String modifiedDate;
    @JsonProperty("allowPings")
    private Boolean allowPings;
    @JsonProperty("pageCustomPrefs")
    private List<String> pageCustomPrefs = null;
    @JsonProperty("dynamicConditional")
    private Boolean dynamicConditional;
    @JsonProperty("commenterAuthenticators")
    private List<String> commenterAuthenticators = null;
    @JsonProperty("host")
    private String host;
    @JsonProperty("ccLicenseUrl")
    private String ccLicenseUrl;
    @JsonProperty("newCreatedUserRoles")
    private List<Object> newCreatedUserRoles = null;
    @JsonProperty("wordsInExcerpt")
    private String wordsInExcerpt;
    @JsonProperty("sortOrderComments")
    private String sortOrderComments;
    @JsonProperty("followAuthLinks")
    private Boolean followAuthLinks;
    @JsonProperty("allowUnregComments")
    private Boolean allowUnregComments;
    @JsonProperty("maxRevisionsTemplate")
    private String maxRevisionsTemplate;
    @JsonProperty("moderatePings")
    private Boolean moderatePings;
    @JsonProperty("customDynamicTemplates")
    private String customDynamicTemplates;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("serverOffset")
    public String getServerOffset() {
        return serverOffset;
    }

    @JsonProperty("serverOffset")
    public void setServerOffset(String serverOffset) {
        this.serverOffset = serverOffset;
    }

    @JsonProperty("themeId")
    public String getThemeId() {
        return themeId;
    }

    @JsonProperty("themeId")
    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    @JsonProperty("statusDefault")
    public String getStatusDefault() {
        return statusDefault;
    }

    @JsonProperty("statusDefault")
    public void setStatusDefault(String statusDefault) {
        this.statusDefault = statusDefault;
    }

    @JsonProperty("autodiscoverLinks")
    public Boolean getAutodiscoverLinks() {
        return autodiscoverLinks;
    }

    @JsonProperty("autodiscoverLinks")
    public void setAutodiscoverLinks(Boolean autodiscoverLinks) {
        this.autodiscoverLinks = autodiscoverLinks;
    }

    @JsonProperty("useRevision")
    public Boolean getUseRevision() {
        return useRevision;
    }

    @JsonProperty("useRevision")
    public void setUseRevision(Boolean useRevision) {
        this.useRevision = useRevision;
    }

    @JsonProperty("relativeUrl")
    public String getRelativeUrl() {
        return relativeUrl;
    }

    @JsonProperty("relativeUrl")
    public void setRelativeUrl(String relativeUrl) {
        this.relativeUrl = relativeUrl;
    }

    @JsonProperty("entryCustomPrefs")
    public List<String> getEntryCustomPrefs() {
        return entryCustomPrefs;
    }

    @JsonProperty("entryCustomPrefs")
    public void setEntryCustomPrefs(List<String> entryCustomPrefs) {
        this.entryCustomPrefs = entryCustomPrefs;
    }

    @JsonProperty("archivePath")
    public String getArchivePath() {
        return archivePath;
    }

    @JsonProperty("archivePath")
    public void setArchivePath(String archivePath) {
        this.archivePath = archivePath;
    }

    @JsonProperty("useCommentConfirmation")
    public Boolean getUseCommentConfirmation() {
        return useCommentConfirmation;
    }

    @JsonProperty("useCommentConfirmation")
    public void setUseCommentConfirmation(Boolean useCommentConfirmation) {
        this.useCommentConfirmation = useCommentConfirmation;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("url")
    public void setUrl(String url) {
        this.url = url;
    }

    @JsonProperty("smartReplaceFields")
    public List<String> getSmartReplaceFields() {
        return smartReplaceFields;
    }

    @JsonProperty("smartReplaceFields")
    public void setSmartReplaceFields(List<String> smartReplaceFields) {
        this.smartReplaceFields = smartReplaceFields;
    }

    @JsonProperty("modifiedBy")
    public ModifiedBy getModifiedBy() {
        return modifiedBy;
    }

    @JsonProperty("modifiedBy")
    public void setModifiedBy(ModifiedBy modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @JsonProperty("operationIfExists")
    public String getOperationIfExists() {
        return operationIfExists;
    }

    @JsonProperty("operationIfExists")
    public void setOperationIfExists(String operationIfExists) {
        this.operationIfExists = operationIfExists;
    }

    @JsonProperty("timezone")
    public String getTimezone() {
        return timezone;
    }

    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    @JsonProperty("daysOrPosts")
    public String getDaysOrPosts() {
        return daysOrPosts;
    }

    @JsonProperty("daysOrPosts")
    public void setDaysOrPosts(String daysOrPosts) {
        this.daysOrPosts = daysOrPosts;
    }

    @JsonProperty("sortOrderPosts")
    public String getSortOrderPosts() {
        return sortOrderPosts;
    }

    @JsonProperty("sortOrderPosts")
    public void setSortOrderPosts(String sortOrderPosts) {
        this.sortOrderPosts = sortOrderPosts;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("convertParas")
    public String getConvertParas() {
        return convertParas;
    }

    @JsonProperty("convertParas")
    public void setConvertParas(String convertParas) {
        this.convertParas = convertParas;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("autoRenameNonAscii")
    public Boolean getAutoRenameNonAscii() {
        return autoRenameNonAscii;
    }

    @JsonProperty("autoRenameNonAscii")
    public void setAutoRenameNonAscii(Boolean autoRenameNonAscii) {
        this.autoRenameNonAscii = autoRenameNonAscii;
    }

    @JsonProperty("includeSystem")
    public String getIncludeSystem() {
        return includeSystem;
    }

    @JsonProperty("includeSystem")
    public void setIncludeSystem(String includeSystem) {
        this.includeSystem = includeSystem;
    }

    @JsonProperty("archiveUrl")
    public String getArchiveUrl() {
        return archiveUrl;
    }

    @JsonProperty("archiveUrl")
    public void setArchiveUrl(String archiveUrl) {
        this.archiveUrl = archiveUrl;
    }

    @JsonProperty("allowCommentHtml")
    public Boolean getAllowCommentHtml() {
        return allowCommentHtml;
    }

    @JsonProperty("allowCommentHtml")
    public void setAllowCommentHtml(Boolean allowCommentHtml) {
        this.allowCommentHtml = allowCommentHtml;
    }

    @JsonProperty("fileExtension")
    public String getFileExtension() {
        return fileExtension;
    }

    @JsonProperty("fileExtension")
    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    @JsonProperty("smartReplace")
    public Integer getSmartReplace() {
        return smartReplace;
    }

    @JsonProperty("smartReplace")
    public void setSmartReplace(Integer smartReplace) {
        this.smartReplace = smartReplace;
    }

    @JsonProperty("junkFolderExpiry")
    public String getJunkFolderExpiry() {
        return junkFolderExpiry;
    }

    @JsonProperty("junkFolderExpiry")
    public void setJunkFolderExpiry(String junkFolderExpiry) {
        this.junkFolderExpiry = junkFolderExpiry;
    }

    @JsonProperty("publishEmptyArchive")
    public Boolean getPublishEmptyArchive() {
        return publishEmptyArchive;
    }

    @JsonProperty("publishEmptyArchive")
    public void setPublishEmptyArchive(Boolean publishEmptyArchive) {
        this.publishEmptyArchive = publishEmptyArchive;
    }

    @JsonProperty("dateLanguage")
    public String getDateLanguage() {
        return dateLanguage;
    }

    @JsonProperty("dateLanguage")
    public void setDateLanguage(String dateLanguage) {
        this.dateLanguage = dateLanguage;
    }

    @JsonProperty("listOnIndex")
    public String getListOnIndex() {
        return listOnIndex;
    }

    @JsonProperty("listOnIndex")
    public void setListOnIndex(String listOnIndex) {
        this.listOnIndex = listOnIndex;
    }

    @JsonProperty("pingWeblogs")
    public Boolean getPingWeblogs() {
        return pingWeblogs;
    }

    @JsonProperty("pingWeblogs")
    public void setPingWeblogs(Boolean pingWeblogs) {
        this.pingWeblogs = pingWeblogs;
    }

    @JsonProperty("extraPath")
    public String getExtraPath() {
        return extraPath;
    }

    @JsonProperty("extraPath")
    public void setExtraPath(String extraPath) {
        this.extraPath = extraPath;
    }

    @JsonProperty("normalizeOrientation")
    public Boolean getNormalizeOrientation() {
        return normalizeOrientation;
    }

    @JsonProperty("normalizeOrientation")
    public void setNormalizeOrientation(Boolean normalizeOrientation) {
        this.normalizeOrientation = normalizeOrientation;
    }

    @JsonProperty("emailNewComments")
    public String getEmailNewComments() {
        return emailNewComments;
    }

    @JsonProperty("emailNewComments")
    public void setEmailNewComments(String emailNewComments) {
        this.emailNewComments = emailNewComments;
    }

    @JsonProperty("language")
    public String getLanguage() {
        return language;
    }

    @JsonProperty("language")
    public void setLanguage(String language) {
        this.language = language;
    }

    @JsonProperty("autolinkUrls")
    public Boolean getAutolinkUrls() {
        return autolinkUrls;
    }

    @JsonProperty("autolinkUrls")
    public void setAutolinkUrls(Boolean autolinkUrls) {
        this.autolinkUrls = autolinkUrls;
    }

    @JsonProperty("sanitizeSpec")
    public String getSanitizeSpec() {
        return sanitizeSpec;
    }

    @JsonProperty("sanitizeSpec")
    public void setSanitizeSpec(String sanitizeSpec) {
        this.sanitizeSpec = sanitizeSpec;
    }

    @JsonProperty("customFields")
    public List<Object> getCustomFields() {
        return customFields;
    }

    @JsonProperty("customFields")
    public void setCustomFields(List<Object> customFields) {
        this.customFields = customFields;
    }

    @JsonProperty("emailNewPings")
    public String getEmailNewPings() {
        return emailNewPings;
    }

    @JsonProperty("emailNewPings")
    public void setEmailNewPings(String emailNewPings) {
        this.emailNewPings = emailNewPings;
    }

    @JsonProperty("nofollowUrls")
    public Boolean getNofollowUrls() {
        return nofollowUrls;
    }

    @JsonProperty("nofollowUrls")
    public void setNofollowUrls(Boolean nofollowUrls) {
        this.nofollowUrls = nofollowUrls;
    }

    @JsonProperty("createdBy")
    public CreatedBy getCreatedBy() {
        return createdBy;
    }

    @JsonProperty("createdBy")
    public void setCreatedBy(CreatedBy createdBy) {
        this.createdBy = createdBy;
    }

    @JsonProperty("pingGoogle")
    public Boolean getPingGoogle() {
        return pingGoogle;
    }

    @JsonProperty("pingGoogle")
    public void setPingGoogle(Boolean pingGoogle) {
        this.pingGoogle = pingGoogle;
    }

    @JsonProperty("convertParasComments")
    public String getConvertParasComments() {
        return convertParasComments;
    }

    @JsonProperty("convertParasComments")
    public void setConvertParasComments(String convertParasComments) {
        this.convertParasComments = convertParasComments;
    }

    @JsonProperty("sitePath")
    public String getSitePath() {
        return sitePath;
    }

    @JsonProperty("sitePath")
    public void setSitePath(String sitePath) {
        this.sitePath = sitePath;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("parent")
    public Object getParent() {
        return parent;
    }

    @JsonProperty("parent")
    public void setParent(Object parent) {
        this.parent = parent;
    }

    @JsonProperty("archiveTypePreferred")
    public String getArchiveTypePreferred() {
        return archiveTypePreferred;
    }

    @JsonProperty("archiveTypePreferred")
    public void setArchiveTypePreferred(String archiveTypePreferred) {
        this.archiveTypePreferred = archiveTypePreferred;
    }

    @JsonProperty("contentCss")
    public String getContentCss() {
        return contentCss;
    }

    @JsonProperty("contentCss")
    public void setContentCss(String contentCss) {
        this.contentCss = contentCss;
    }

    @JsonProperty("junkScoreThreshold")
    public String getJunkScoreThreshold() {
        return junkScoreThreshold;
    }

    @JsonProperty("junkScoreThreshold")
    public void setJunkScoreThreshold(String junkScoreThreshold) {
        this.junkScoreThreshold = junkScoreThreshold;
    }

    @JsonProperty("internalAutodiscovery")
    public Boolean getInternalAutodiscovery() {
        return internalAutodiscovery;
    }

    @JsonProperty("internalAutodiscovery")
    public void setInternalAutodiscovery(Boolean internalAutodiscovery) {
        this.internalAutodiscovery = internalAutodiscovery;
    }

    @JsonProperty("createdDate")
    public String getCreatedDate() {
        return createdDate;
    }

    @JsonProperty("createdDate")
    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @JsonProperty("class")
    public String getClass_() {
        return _class;
    }

    @JsonProperty("class")
    public void setClass_(String _class) {
        this._class = _class;
    }

    @JsonProperty("moderateComments")
    public String getModerateComments() {
        return moderateComments;
    }

    @JsonProperty("moderateComments")
    public void setModerateComments(String moderateComments) {
        this.moderateComments = moderateComments;
    }

    @JsonProperty("allowCommentsDefault")
    public Boolean getAllowCommentsDefault() {
        return allowCommentsDefault;
    }

    @JsonProperty("allowCommentsDefault")
    public void setAllowCommentsDefault(Boolean allowCommentsDefault) {
        this.allowCommentsDefault = allowCommentsDefault;
    }

    @JsonProperty("includeCache")
    public Boolean getIncludeCache() {
        return includeCache;
    }

    @JsonProperty("includeCache")
    public void setIncludeCache(Boolean includeCache) {
        this.includeCache = includeCache;
    }

    @JsonProperty("allowCommenterRegist")
    public Boolean getAllowCommenterRegist() {
        return allowCommenterRegist;
    }

    @JsonProperty("allowCommenterRegist")
    public void setAllowCommenterRegist(Boolean allowCommenterRegist) {
        this.allowCommenterRegist = allowCommenterRegist;
    }

    @JsonProperty("allowToChangeAtUpload")
    public Boolean getAllowToChangeAtUpload() {
        return allowToChangeAtUpload;
    }

    @JsonProperty("allowToChangeAtUpload")
    public void setAllowToChangeAtUpload(Boolean allowToChangeAtUpload) {
        this.allowToChangeAtUpload = allowToChangeAtUpload;
    }

    @JsonProperty("uploadDestination")
    public UploadDestination getUploadDestination() {
        return uploadDestination;
    }

    @JsonProperty("uploadDestination")
    public void setUploadDestination(UploadDestination uploadDestination) {
        this.uploadDestination = uploadDestination;
    }

    @JsonProperty("maxRevisionsEntry")
    public String getMaxRevisionsEntry() {
        return maxRevisionsEntry;
    }

    @JsonProperty("maxRevisionsEntry")
    public void setMaxRevisionsEntry(String maxRevisionsEntry) {
        this.maxRevisionsEntry = maxRevisionsEntry;
    }

    @JsonProperty("updatable")
    public Boolean getUpdatable() {
        return updatable;
    }

    @JsonProperty("updatable")
    public void setUpdatable(Boolean updatable) {
        this.updatable = updatable;
    }

    @JsonProperty("requireCommentEmails")
    public Boolean getRequireCommentEmails() {
        return requireCommentEmails;
    }

    @JsonProperty("requireCommentEmails")
    public void setRequireCommentEmails(Boolean requireCommentEmails) {
        this.requireCommentEmails = requireCommentEmails;
    }

    @JsonProperty("ccLicenseImage")
    public String getCcLicenseImage() {
        return ccLicenseImage;
    }

    @JsonProperty("ccLicenseImage")
    public void setCcLicenseImage(String ccLicenseImage) {
        this.ccLicenseImage = ccLicenseImage;
    }

    @JsonProperty("allowComments")
    public Boolean getAllowComments() {
        return allowComments;
    }

    @JsonProperty("allowComments")
    public void setAllowComments(Boolean allowComments) {
        this.allowComments = allowComments;
    }

    @JsonProperty("allowPingsDefault")
    public Boolean getAllowPingsDefault() {
        return allowPingsDefault;
    }

    @JsonProperty("allowPingsDefault")
    public void setAllowPingsDefault(Boolean allowPingsDefault) {
        this.allowPingsDefault = allowPingsDefault;
    }

    @JsonProperty("pingOthers")
    public List<Object> getPingOthers() {
        return pingOthers;
    }

    @JsonProperty("pingOthers")
    public void setPingOthers(List<Object> pingOthers) {
        this.pingOthers = pingOthers;
    }

    @JsonProperty("basenameLimit")
    public String getBasenameLimit() {
        return basenameLimit;
    }

    @JsonProperty("basenameLimit")
    public void setBasenameLimit(String basenameLimit) {
        this.basenameLimit = basenameLimit;
    }

    @JsonProperty("dynamicCache")
    public Boolean getDynamicCache() {
        return dynamicCache;
    }

    @JsonProperty("dynamicCache")
    public void setDynamicCache(Boolean dynamicCache) {
        this.dynamicCache = dynamicCache;
    }

    @JsonProperty("modifiedDate")
    public String getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("allowPings")
    public Boolean getAllowPings() {
        return allowPings;
    }

    @JsonProperty("allowPings")
    public void setAllowPings(Boolean allowPings) {
        this.allowPings = allowPings;
    }

    @JsonProperty("pageCustomPrefs")
    public List<String> getPageCustomPrefs() {
        return pageCustomPrefs;
    }

    @JsonProperty("pageCustomPrefs")
    public void setPageCustomPrefs(List<String> pageCustomPrefs) {
        this.pageCustomPrefs = pageCustomPrefs;
    }

    @JsonProperty("dynamicConditional")
    public Boolean getDynamicConditional() {
        return dynamicConditional;
    }

    @JsonProperty("dynamicConditional")
    public void setDynamicConditional(Boolean dynamicConditional) {
        this.dynamicConditional = dynamicConditional;
    }

    @JsonProperty("commenterAuthenticators")
    public List<String> getCommenterAuthenticators() {
        return commenterAuthenticators;
    }

    @JsonProperty("commenterAuthenticators")
    public void setCommenterAuthenticators(List<String> commenterAuthenticators) {
        this.commenterAuthenticators = commenterAuthenticators;
    }

    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty("ccLicenseUrl")
    public String getCcLicenseUrl() {
        return ccLicenseUrl;
    }

    @JsonProperty("ccLicenseUrl")
    public void setCcLicenseUrl(String ccLicenseUrl) {
        this.ccLicenseUrl = ccLicenseUrl;
    }

    @JsonProperty("newCreatedUserRoles")
    public List<Object> getNewCreatedUserRoles() {
        return newCreatedUserRoles;
    }

    @JsonProperty("newCreatedUserRoles")
    public void setNewCreatedUserRoles(List<Object> newCreatedUserRoles) {
        this.newCreatedUserRoles = newCreatedUserRoles;
    }

    @JsonProperty("wordsInExcerpt")
    public String getWordsInExcerpt() {
        return wordsInExcerpt;
    }

    @JsonProperty("wordsInExcerpt")
    public void setWordsInExcerpt(String wordsInExcerpt) {
        this.wordsInExcerpt = wordsInExcerpt;
    }

    @JsonProperty("sortOrderComments")
    public String getSortOrderComments() {
        return sortOrderComments;
    }

    @JsonProperty("sortOrderComments")
    public void setSortOrderComments(String sortOrderComments) {
        this.sortOrderComments = sortOrderComments;
    }

    @JsonProperty("followAuthLinks")
    public Boolean getFollowAuthLinks() {
        return followAuthLinks;
    }

    @JsonProperty("followAuthLinks")
    public void setFollowAuthLinks(Boolean followAuthLinks) {
        this.followAuthLinks = followAuthLinks;
    }

    @JsonProperty("allowUnregComments")
    public Boolean getAllowUnregComments() {
        return allowUnregComments;
    }

    @JsonProperty("allowUnregComments")
    public void setAllowUnregComments(Boolean allowUnregComments) {
        this.allowUnregComments = allowUnregComments;
    }

    @JsonProperty("maxRevisionsTemplate")
    public String getMaxRevisionsTemplate() {
        return maxRevisionsTemplate;
    }

    @JsonProperty("maxRevisionsTemplate")
    public void setMaxRevisionsTemplate(String maxRevisionsTemplate) {
        this.maxRevisionsTemplate = maxRevisionsTemplate;
    }

    @JsonProperty("moderatePings")
    public Boolean getModeratePings() {
        return moderatePings;
    }

    @JsonProperty("moderatePings")
    public void setModeratePings(Boolean moderatePings) {
        this.moderatePings = moderatePings;
    }

    @JsonProperty("customDynamicTemplates")
    public String getCustomDynamicTemplates() {
        return customDynamicTemplates;
    }

    @JsonProperty("customDynamicTemplates")
    public void setCustomDynamicTemplates(String customDynamicTemplates) {
        this.customDynamicTemplates = customDynamicTemplates;
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
