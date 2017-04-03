package com.github.movabletype.data.api;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import com.github.movabletype.data.api.pojo.Asset;
import com.github.movabletype.data.api.pojo.AssetItems;
import com.github.movabletype.data.api.pojo.Authentication;
import com.github.movabletype.data.api.pojo.Category;
import com.github.movabletype.data.api.pojo.CategoryItems;
import com.github.movabletype.data.api.pojo.CreateUser;
import com.github.movabletype.data.api.pojo.Entry;
import com.github.movabletype.data.api.pojo.EntryItems;
import com.github.movabletype.data.api.pojo.Site;
import com.github.movabletype.data.api.pojo.SiteItems;
import com.github.movabletype.data.api.pojo.Status;
import com.github.movabletype.data.api.pojo.User;
import com.github.movabletype.data.api.pojo.UserItems;
import com.github.movabletype.data.api.pojo.Version;
import com.github.movabletype.data.api.request.AssetSearchParam;
import com.github.movabletype.data.api.request.CategorySearchParam;
import com.github.movabletype.data.api.request.EntrySearchParam;
import com.github.movabletype.data.api.request.SiteSearchParam;
import com.github.movabletype.data.api.request.UploadParam;
import com.github.movabletype.data.api.request.UserSearchParam;

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

    Site updateSite(int site_id, Site site) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    /******************************************************
     * Entry
     ******************************************************/
    Entry postEntry(int i, Entry entry) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Entry deleteEntry(int site_id, Integer entry_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    EntryItems getEntries(int site_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Entry getEntry(int site_id, int entry_id, String fields) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    EntryItems searchEntry(EntrySearchParam search) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Entry updateEntry(int site_id, int entry_id, Entry entry) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    /******************************************************
     * Asset
     ******************************************************/
    Asset uploadAsset(UploadParam upload) throws IOException, KeyManagementException, NoSuchAlgorithmException;

    Asset deleteAsset(int site_id, int asset_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Asset getAsset(int site_id, int asset_id, String fields) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    AssetItems searchAsset(int site_id, AssetSearchParam search) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    /******************************************************
     * Category
     ******************************************************/
    Category createCategory(int site_id, Category category) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Category deleteCategory(int site_id, int category_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Category getCategory(int site_id, int category_id, String fields) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    CategoryItems searchCategory(int site_id, CategorySearchParam search) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Category updateCategory(int site_id, int category_id, Category category) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    /******************************************************
     * User
     ******************************************************/
    User createUser(CreateUser createUser) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    User deleteUser(int user_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    UserItems searchUser(UserSearchParam userSearchParam) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    User updateUser(int user_id, User user) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    User getUser(String user_id, String fields) throws KeyManagementException, NoSuchAlgorithmException, IOException;

    Status unlockUser(int user_id) throws KeyManagementException, NoSuchAlgorithmException, IOException;
}
