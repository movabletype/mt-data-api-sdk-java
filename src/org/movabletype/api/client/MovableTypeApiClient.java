package org.movabletype.api.client;

import java.io.IOException;

import org.movabletype.api.client.pojo.Asset;
import org.movabletype.api.client.pojo.AssetItems;
import org.movabletype.api.client.pojo.Authentication;
import org.movabletype.api.client.pojo.Category;
import org.movabletype.api.client.pojo.CategoryItems;
import org.movabletype.api.client.pojo.Entry;
import org.movabletype.api.client.pojo.EntryItems;
import org.movabletype.api.client.pojo.FolderItems;
import org.movabletype.api.client.pojo.Provider;
import org.movabletype.api.client.pojo.Site;
import org.movabletype.api.client.pojo.SiteItems;
import org.movabletype.api.client.pojo.StatItems;
import org.movabletype.api.client.pojo.Status;
import org.movabletype.api.client.pojo.Template;
import org.movabletype.api.client.pojo.TemplateItems;
import org.movabletype.api.client.pojo.Theme;
import org.movabletype.api.client.pojo.ThemeItems;
import org.movabletype.api.client.pojo.User;
import org.movabletype.api.client.pojo.UserItems;
import org.movabletype.api.client.pojo.Version;
import org.movabletype.api.client.request.AssetSearchParam;
import org.movabletype.api.client.request.CategorySearchParam;
import org.movabletype.api.client.request.EntrySearchParam;
import org.movabletype.api.client.request.FolderSearchParam;
import org.movabletype.api.client.request.SearchParam;
import org.movabletype.api.client.request.SiteSearchParam;
import org.movabletype.api.client.request.StatSearchParam;
import org.movabletype.api.client.request.TemplateSearchParam;
import org.movabletype.api.client.request.UploadParam;
import org.movabletype.api.client.request.UserSearchParam;

public interface MovableTypeApiClient {

    /******************************************************
     * API
     ******************************************************/
    Version getVersion() throws IOException;

    void setVersion(String version);

    void setEndpoint(String endpoint);

    String getEndpoint();

    int getResponseCode() throws IOException;

    String getResponseMessage() throws IOException;

    String getResponseBody() throws IOException;

    /******************************************************
     * Authentication
     ******************************************************/
    Authentication getAuthentication();

    Status deleteToken() throws IOException;

    Status signOut() throws IOException;

    /******************************************************
     * Site
     ******************************************************/
    Site createWebsite(Site site) throws IOException;

    Site createBlog(int site_id, Site site) throws IOException;

    Site deleteSite(int site_id) throws IOException;

    Site getSite(int site_id, String fields) throws IOException;

    SiteItems searchSite(SiteSearchParam siteSearchParam) throws IOException;

    Site updateSite(Site site) throws IOException;

    Site updateBlog(Site site) throws IOException;

    /******************************************************
     * Entry
     ******************************************************/
    Entry postEntry(int site_id, Entry entry) throws IOException;

    Entry deleteEntry(int site_id, Integer entry_id) throws IOException;

    Entry getEntry(EntrySearchParam search) throws IOException;

    EntryItems searchEntry(EntrySearchParam search) throws IOException;

    Entry updateEntry(int site_id, Entry entry) throws IOException;

    /******************************************************
     * Asset
     ******************************************************/
    Asset uploadAsset(UploadParam upload) throws IOException;

    Asset deleteAsset(int site_id, int asset_id) throws IOException;

    Asset getAsset(int site_id, int asset_id, String fields) throws IOException;

    AssetItems searchAsset(AssetSearchParam search) throws IOException;

    Asset updateAsset(int site_id, Asset asset) throws IOException;

    /******************************************************
     * Category
     ******************************************************/
    Category createCategory(int site_id, Category category) throws IOException;

    Category deleteCategory(int site_id, int category_id) throws IOException;

    Category getCategory(int site_id, int category_id, String fields) throws IOException;

    CategoryItems searchCategory(CategorySearchParam search) throws IOException;

    Category updateCategory(int site_id, Category category) throws IOException;

    /******************************************************
     * User
     ******************************************************/
    User createUser(User user) throws IOException;

    User deleteUser(int user_id) throws IOException;

    UserItems searchUser(UserSearchParam userSearchParam) throws IOException;

    User updateUser(User user) throws IOException;

    User getUser(String user_id, String fields) throws IOException;

    Status unlockUser(int user_id) throws IOException;
    
    /******************************************************
     * Search
     ******************************************************/
    EntryItems search(SearchParam search) throws IOException;

    /******************************************************
     * Template
     ******************************************************/
    Status rebuild(int site_id, int template_id) throws IOException;

    Status resetAllTemplate(int site_id, String refresh_type) throws IOException;

    Status resetTemplate(int site_id, int template_id) throws IOException;

    Template createTemplate(int site_id, Template template) throws IOException;

    Template updateTemplate(int site_id, Template template) throws IOException;

    Template deleteTemplate(int site_id, int template_id ) throws IOException;

    TemplateItems searchTemplate(TemplateSearchParam search) throws IOException;

    /******************************************************
     * Theme
     ******************************************************/
    ThemeItems getThemeList() throws IOException;

    Theme getTheme(String theme_id) throws IOException;

    Status applyTheme(int site_id, String theme_id) throws IOException;

    /******************************************************
     * Folder
     ******************************************************/
    FolderItems searchFolder(FolderSearchParam search) throws IOException;

    FolderItems searchParentsFolder(int site_id, int folder_id, int maxDepth, int includeCurrent) throws IOException;

    FolderItems searchSiblingsFolder(FolderSearchParam search) throws IOException;

    FolderItems searchChildFolder(int site_id, int folder_id, int maxDepth, int includeCurrent) throws IOException;

    /******************************************************
     * Stats
     ******************************************************/
    StatItems searchStatVisitPath (StatSearchParam search) throws IOException;

    StatItems searchStatVisitDate (StatSearchParam search) throws IOException;

    StatItems searchStatPageViewPath (StatSearchParam search) throws IOException;

    StatItems searchStatPageViewDate (StatSearchParam search) throws IOException;

    Provider getStatProvider(int site_id) throws IOException;
}