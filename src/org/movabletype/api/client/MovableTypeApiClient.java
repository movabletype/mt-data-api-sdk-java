package org.movabletype.api.client;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

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
    Version getVersion() throws KeyManagementException, NoSuchAlgorithmException, IOException;

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

    Status deleteToken() throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Status signOut() throws KeyManagementException, NoSuchAlgorithmException, IOException;

    /******************************************************
     * Site
     ******************************************************/
    Site createWebsite(Site site) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Site createBlog(int site_id, Site site) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Site deleteSite(int site_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Site getSite(int site_id, String fields) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    SiteItems searchSites(SiteSearchParam siteSearchParam) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Site updateSite(Site site) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Site updateBlog(Site site) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    /******************************************************
     * Entry
     ******************************************************/
    Entry postEntry(int site_id, Entry entry) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Entry deleteEntry(int site_id, Integer entry_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Entry getEntry(int site_id, int entry_id, String fields) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    EntryItems searchEntry(EntrySearchParam search) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Entry updateEntry(int site_id, Entry entry) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    /******************************************************
     * Asset
     ******************************************************/
    Asset uploadAsset(UploadParam upload) throws IOException, KeyManagementException, NoSuchAlgorithmException;

    Asset deleteAsset(int site_id, int asset_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Asset getAsset(int site_id, int asset_id, String fields) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    AssetItems searchAsset(int site_id, AssetSearchParam search) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Asset updateAsset(int site_id, Asset asset) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    /******************************************************
     * Category
     ******************************************************/
    Category createCategory(int site_id, Category category) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Category deleteCategory(int site_id, int category_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Category getCategory(int site_id, int category_id, String fields) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    CategoryItems searchCategory(int site_id, CategorySearchParam search) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Category updateCategory(int site_id, Category category) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    /******************************************************
     * User
     ******************************************************/
    User createUser(CreateUser createUser) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    User deleteUser(int user_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    UserItems searchUser(UserSearchParam userSearchParam) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    User updateUser(User user) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    User getUser(String user_id, String fields) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Status unlockUser(int user_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;
}
