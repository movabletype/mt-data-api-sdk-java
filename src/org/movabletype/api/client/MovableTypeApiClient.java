package org.movabletype.api.client;

import java.io.IOException;

import org.movabletype.api.client.pojo.Asset;
import org.movabletype.api.client.pojo.AssetItems;
import org.movabletype.api.client.pojo.Authentication;
import org.movabletype.api.client.pojo.Category;
import org.movabletype.api.client.pojo.CategoryItems;
import org.movabletype.api.client.pojo.CreateUser;
import org.movabletype.api.client.pojo.Entry;
import org.movabletype.api.client.pojo.EntryItems;
import org.movabletype.api.client.pojo.Site;
import org.movabletype.api.client.pojo.SiteItems;
import org.movabletype.api.client.pojo.Status;
import org.movabletype.api.client.pojo.User;
import org.movabletype.api.client.pojo.UserItems;
import org.movabletype.api.client.pojo.Version;
import org.movabletype.api.client.request.AssetSearchParam;
import org.movabletype.api.client.request.CategorySearchParam;
import org.movabletype.api.client.request.EntrySearchParam;
import org.movabletype.api.client.request.SiteSearchParam;
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

    SiteItems searchSites(SiteSearchParam siteSearchParam) throws IOException;

    Site updateSite(Site site) throws IOException;

    Site updateBlog(Site site) throws IOException;

    /******************************************************
     * Entry
     ******************************************************/
    Entry postEntry(int site_id, Entry entry) throws IOException;

    Entry deleteEntry(int site_id, Integer entry_id) throws IOException;

    Entry getEntry(int site_id, int entry_id, String fields) throws IOException;

    EntryItems searchEntry(EntrySearchParam search) throws IOException;

    Entry updateEntry(int site_id, Entry entry) throws IOException;

    /******************************************************
     * Asset
     ******************************************************/
    Asset uploadAsset(UploadParam upload) throws IOException;

    Asset deleteAsset(int site_id, int asset_id) throws IOException;

    Asset getAsset(int site_id, int asset_id, String fields) throws IOException;

    AssetItems searchAsset(int site_id, AssetSearchParam search) throws IOException;

    Asset updateAsset(int site_id, Asset asset) throws IOException;

    /******************************************************
     * Category
     ******************************************************/
    Category createCategory(int site_id, Category category) throws IOException;

    Category deleteCategory(int site_id, int category_id) throws IOException;

    Category getCategory(int site_id, int category_id, String fields) throws IOException;

    CategoryItems searchCategory(int site_id, CategorySearchParam search) throws IOException;

    Category updateCategory(int site_id, Category category) throws IOException;

    /******************************************************
     * User
     ******************************************************/
    User createUser(CreateUser createUser) throws IOException;

    User deleteUser(int user_id) throws IOException;

    UserItems searchUser(UserSearchParam userSearchParam) throws IOException;

    User updateUser(User user) throws IOException;

    User getUser(String user_id, String fields) throws IOException;

    Status unlockUser(int user_id) throws IOException;
}
