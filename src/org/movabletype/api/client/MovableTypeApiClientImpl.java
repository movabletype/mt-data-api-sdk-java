package org.movabletype.api.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLConnection;
import java.util.HashMap;

import org.movabletype.api.client.pojo.Asset;
import org.movabletype.api.client.pojo.AssetItems;
import org.movabletype.api.client.pojo.Authentication;
import org.movabletype.api.client.pojo.Category;
import org.movabletype.api.client.pojo.CategoryItems;
import org.movabletype.api.client.pojo.Entry;
import org.movabletype.api.client.pojo.EntryItems;
import org.movabletype.api.client.pojo.FolderItems;
import org.movabletype.api.client.pojo.Site;
import org.movabletype.api.client.pojo.SiteItems;
import org.movabletype.api.client.pojo.Status;
import org.movabletype.api.client.pojo.Template;
import org.movabletype.api.client.pojo.TemplateItems;
import org.movabletype.api.client.pojo.Theme;
import org.movabletype.api.client.pojo.ThemeItems;
import org.movabletype.api.client.pojo.Token;
import org.movabletype.api.client.pojo.User;
import org.movabletype.api.client.pojo.UserItems;
import org.movabletype.api.client.pojo.Version;
import org.movabletype.api.client.request.AssetSearchParam;
import org.movabletype.api.client.request.CategorySearchParam;
import org.movabletype.api.client.request.EntrySearchParam;
import org.movabletype.api.client.request.FolderSearchParam;
import org.movabletype.api.client.request.SearchParam;
import org.movabletype.api.client.request.SiteSearchParam;
import org.movabletype.api.client.request.TemplateSearchParam;
import org.movabletype.api.client.request.UploadParam;
import org.movabletype.api.client.request.UserSearchParam;
import org.movabletype.api.net.MovableTypeApiConnection;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MovableTypeApiClientImpl implements MovableTypeApiClient {

    private Token token;
    private long expire;
    private String version;
    private String endpoint;
    private MovableTypeApiConnection conn;
    private Authentication authentication;

    /******************************************************
     * API
     ******************************************************/
    @Override
    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }

    @Override
    public Version getVersion() throws IOException {
        String url = endpoint + "/" + version + "/version";
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        Version apiversion = mapper.readValue(conn.getResponseBody(), Version.class);
        conn.disconnect();
        return apiversion;
    }

    @Override
    public int getResponseCode() throws IOException {
        return conn.getStatus();
    }

    @Override
    public String getResponseMessage() throws IOException {
        return conn.getMessage();
    }

    @Override
    public String getResponseBody() throws IOException {
        return conn.getBody();
    }

    /******************************************************
     * Authentication
     ******************************************************/
    /**
     * MovableTypeApiClientImpl
     * 
     * @param username
     * @param password
     * @param clientId
     * @param endpoint
     * @throws IOException
     */
    public MovableTypeApiClientImpl(String username, String password, String clientId, String endpoint) throws IOException {
        this.endpoint = endpoint;
        expire = 0L;
        version = "v3";
        String url = endpoint + "/" + version + "/authentication?username=" + username + "&password=" + password + "&clientId=" + clientId;
        conn = new MovableTypeApiConnection();
        conn.connectUrl(url);
        conn.setRequestMethod("POST");
        ObjectMapper mapper = new ObjectMapper();
        authentication = mapper.readValue(conn.getResponseBody(), Authentication.class);
        conn.disconnect();
    }

    /**
     * MovableTypeApiClientImpl - Basic Authentication
     * 
     * @param username
     * @param password
     * @param clientId
     * @param endpoint
     * @param authUsername
     * @param authPassword
     * @throws IOException
     */
    public MovableTypeApiClientImpl(String username, String password, String clientId, String endpoint, String authUsername, String authPassword)
            throws IOException {
        this.endpoint = endpoint;
        expire = 0L;
        version = "v3";
        String url = endpoint + "/" + version + "/authentication?username=" + username + "&password=" + password + "&clientId=" + clientId;
        conn = new MovableTypeApiConnection();
        conn.setBasicAuthentication(authUsername, authPassword);
        conn.connectUrl(url);
        conn.setRequestMethod("POST");
        ObjectMapper mapper = new ObjectMapper();
        authentication = mapper.readValue(conn.getResponseBody(), Authentication.class);
        conn.disconnect();
    }
    
    /**
     * MovableTypeApiClientImpl - Connection not authenticated
     * 
     * @param clientId
     * @param endpoint
     * @throws IOException
     */
    public MovableTypeApiClientImpl(String clientId, String endpoint ) throws IOException {
        this.endpoint = endpoint;
        expire = 0L;
        version = "v3";
        authentication = null;
        conn = new MovableTypeApiConnection();
        this.getVersion();  // connection check.
    }

    /**
     * getToken
     * 
     * @return
     * @throws IOException
     */
    private Token getToken() throws IOException {
        Long now = System.currentTimeMillis() / 1000L;
        if ( authentication == null )
            return null;
        if (expire > now)
            return token;
        String url = endpoint + "/" + version + "/token";
        conn.connectUrl(url);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth sessionId=" + authentication.getSessionId());
        ObjectMapper mapper = new ObjectMapper();
        token = mapper.readValue(conn.getResponseBody(), Token.class);
        conn.disconnect();
        conn.setToken(token);
        expire = System.currentTimeMillis() / 1000L + token.getExpiresIn();
        return token;
    }

    @Override
    public Authentication getAuthentication() {
        return authentication;
    }

    @Override
    public Status deleteToken() throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/token";
        conn.connectUrl(url);
        conn.setRequestMethod("DELETE");
        ObjectMapper mapper = new ObjectMapper();
        Status status = mapper.readValue(conn.getResponseBody(), Status.class);
        conn.disconnect();
        expire = 0;
        return status;
    }

    @Override
    public Status signOut() throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/authentication";
        conn.connectUrl(url);
        conn.setRequestMethod("DELETE");
        ObjectMapper mapper = new ObjectMapper();
        Status status = mapper.readValue(conn.getResponseBody(), Status.class);
        conn.disconnect();
        return status;
    }

    /******************************************************
     * Site
     * 
     * @throws IOException
     ******************************************************/
    @Override
    public Site createWebsite(Site site) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites";
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(site);
        conn.addBodyPart("website=" + json);
        Site createSite = mapper.readValue(conn.getResponseBody(), Site.class);
        conn.disconnect();
        return createSite;
    }

    @Override
    public Site createBlog(int site_id, Site site) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id;
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(site);
        conn.addBodyPart("blog=" + json);
        Site createSite = mapper.readValue(conn.getResponseBody(), Site.class);
        conn.disconnect();
        return createSite;
    }

    @Override
    public Site deleteSite(int site_id) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id;
        conn.connectUrl(url);
        conn.setRequestMethod("DELETE");
        ObjectMapper mapper = new ObjectMapper();
        Site deleteSite = mapper.readValue(conn.getResponseBody(), Site.class);
        conn.disconnect();
        return deleteSite;
    }

    @Override
    public Site getSite(int site_id, String fields) throws IOException {
        this.getToken();
        if (fields == null)
            fields = "";
        String url = endpoint + "/" + version + "/sites/" + site_id + "?fields=" + fields;
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        Site site = mapper.readValue(conn.getResponseBody(), Site.class);
        conn.disconnect();
        return site;
    }

    @Override
    public SiteItems searchSites(SiteSearchParam siteSearchParam) throws IOException {
        this.getToken();
        String user_id = siteSearchParam.getUser_id();
        int site_id = siteSearchParam.getSite_id();
        String url = new String();
        if ( user_id != null ) {
            url = endpoint + "/" + version + "/users/" + user_id +"/sites?" + siteSearchParam.getQueryString();
        } else if ( site_id != 0 ) {
            url = endpoint + "/" + version + "/sites/" + site_id + "/children?" + siteSearchParam.getQueryString();
        } else {
            url = endpoint + "/" + version + "/sites?" + siteSearchParam.getQueryString();
        }
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        SiteItems siteItems = mapper.readValue(conn.getResponseBody(), SiteItems.class);
        conn.disconnect();
        return siteItems;
    }

    @Override
    public Site updateSite(Site site) throws IOException {
        int site_id = site.getId();
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id;
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(site);
        conn.addBodyPart("website=" + json);
        site = mapper.readValue(conn.getResponseBody(), Site.class);
        conn.disconnect();
        return site;
    }

    @Override
    public Site updateBlog(Site site) throws IOException {
        int site_id = Integer.valueOf(site.getId());
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id;
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(site);
        conn.addBodyPart("blog=" + json);
        site = mapper.readValue(conn.getResponseBody(), Site.class);
        conn.disconnect();
        return site;
    }

    /******************************************************
     * Entry
     ******************************************************/
    @Override
    public Entry postEntry(int site_id, Entry entry) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/entries";
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entry);
        conn.addBodyPart("entry=" + json);
        Entry postedEntry = mapper.readValue(conn.getResponseBody(), Entry.class);
        conn.disconnect();
        return postedEntry;
    }

    @Override
    public Entry deleteEntry(int site_id, Integer entry_id) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/entries/" + entry_id;
        conn.connectUrl(url);
        conn.setRequestMethod("DELETE");
        ObjectMapper mapper = new ObjectMapper();
        Entry deleteEntry = mapper.readValue(conn.getResponseBody(), Entry.class);
        conn.disconnect();
        return deleteEntry;
    }

    @Override
    public Entry getEntry(EntrySearchParam search) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + search.getSite_id() + "/entries/" + search.getEntry_id() + "?" + search.getQueryString();
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        Entry entry = mapper.readValue(conn.getResponseBody(), Entry.class);
        conn.disconnect();
        return entry;
    }

    @Override
    public EntryItems searchEntry(EntrySearchParam search) throws IOException {
        int  site_id = search.getSite_id();
        int  category_id = search.getCategory_id();
        int  asset_id = search.getAsset_id();
        int  tag_id = search.getTag_id();
        this.getToken();
        String url = new String();
        if ( category_id != 0 && site_id != 0 ) {
            url = endpoint + "/" + version + "/sites/" + site_id + "/categories/" + category_id + "/entries?" + search.getQueryString();
        } else if ( asset_id != 0 && site_id != 0 ) {
            url = endpoint + "/" + version + "/sites/" + site_id + "/assets/" + asset_id + "/entries?" + search.getQueryString();
        } else if ( tag_id != 0 && site_id != 0 ) {
            url = endpoint + "/" + version + "/sites/" + site_id + "/tags/" + tag_id + "/entries?" + search.getQueryString();
        } else {
            url = endpoint + "/" + version + "/sites/" + site_id + "/entries?" + search.getQueryString();
        }
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        EntryItems entries = mapper.readValue(conn.getResponseBody(), EntryItems.class);
        conn.disconnect();
        return entries;
    }

    @Override
    public Entry updateEntry(int site_id, Entry entry) throws IOException {
        int entry_id = entry.getId();
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/entries/" + entry_id;
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entry);
        conn.addBodyPart("entry=" + json);
        entry = mapper.readValue(conn.getResponseBody(), Entry.class);
        conn.disconnect();
        return entry;
    }

    /******************************************************
     * Asset
     ******************************************************/

    @SuppressWarnings("rawtypes")
    @Override
    public Asset uploadAsset(UploadParam upload) throws IOException {
        this.getToken();
        String overwrite = "";
        if (upload.isOverwrite_once() == true)
            overwrite = "?overwrite_once=1";
        String url = endpoint + "/" + version + "/assets/upload" + overwrite;
        Asset asset = null;
        String CRLF = "\r\n";
        String charset = "UTF-8";
        String boundary = "---------------------------" + Long.toString(System.currentTimeMillis());
        conn.connectUrl(url);
        conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        OutputStream outputStream = conn.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, charset), true);
        HashMap<String, Comparable> requestBody = new HashMap<String, Comparable>();
        requestBody.put("site_id", upload.getSite_id());
        requestBody.put("path", upload.getUploadPath());
        requestBody.put("autoRenameIfExists", upload.isAutoRenameIfExists());
        requestBody.put("normalizeOrientation", upload.isNormalizeOrientation());
        for (java.util.Map.Entry<String, Comparable> req : requestBody.entrySet()) {
            writer.append("--" + boundary).append(CRLF);
            writer.append("Content-Disposition: form-data; name=\"" + req.getKey() + "\"").append(CRLF);
            writer.append(CRLF);
            writer.append(req.getValue().toString()).append(CRLF);
        }
        File uploadFile = new File(upload.getUploadLocalfile());
        String fileName = uploadFile.getName();
        writer.append("--" + boundary).append(CRLF);
        writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + fileName + "\"").append(CRLF);
        writer.append("Content-Type: " + URLConnection.guessContentTypeFromName(fileName)).append(CRLF);
        writer.append("Content-Transfer-Encoding: binary").append(CRLF);
        writer.append(CRLF);
        writer.flush();
        FileInputStream inputStream = new FileInputStream(uploadFile);
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        outputStream.flush();
        inputStream.close();
        writer.append(CRLF).flush();
        writer.append("--" + boundary + "--").append(CRLF);
        writer.append(CRLF);
        writer.close();
        ObjectMapper mapper = new ObjectMapper();
        asset = mapper.readValue(conn.getResponseBody(), Asset.class);
        conn.disconnect();
        return asset;
    }

    @Override
    public Asset deleteAsset(int site_id, int asset_id) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/assets/" + asset_id;
        conn.connectUrl(url);
        conn.setRequestMethod("DELETE");
        ObjectMapper mapper = new ObjectMapper();
        Asset asset = mapper.readValue(conn.getResponseBody(), Asset.class);
        conn.disconnect();
        return asset;
    }

    @Override
    public Asset getAsset(int site_id, int asset_id, String fields) throws IOException {
        this.getToken();
        if (fields == null)
            fields = "";
        String url = endpoint + "/" + version + "/sites/" + site_id + "/assets/" + asset_id + "?fields=" + fields;
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        Asset asset = mapper.readValue(conn.getResponseBody(), Asset.class);
        conn.disconnect();
        return asset;
    }

    @Override
    public AssetItems searchAsset(AssetSearchParam search) throws IOException {
        this.getToken();
        int site_id = search.getSite_id();
        int entry_id = search.getEntry_id();
        int page_id = search.getPage_id();
        int tag_id = search.getTag_id();
        String url = new String();
        if ( entry_id != 0 &&  site_id != 0 ) {
            url = endpoint + "/" + version + "/sites/" + site_id + "/entries/" +  entry_id + "/assets?" + search.getQueryString();
        } else if ( page_id != 0 &&  site_id != 0 ) {
            url = endpoint + "/" + version + "/sites/" + site_id + "/pages/" +  page_id + "/assets?" + search.getQueryString();
        } else if ( tag_id != 0 &&  site_id != 0 ) {
            url = endpoint + "/" + version + "/sites/" + site_id + "/tags/" +  tag_id + "/assets?" + search.getQueryString();
        } else {
            url = endpoint + "/" + version + "/sites/" + site_id + "/assets?" + search.getQueryString();
        }
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        AssetItems assets = mapper.readValue(conn.getResponseBody(), AssetItems.class);
        conn.disconnect();
        return assets;
    }

    @Override
    public Asset updateAsset(int site_id, Asset asset) throws IOException {
        int asset_id = asset.getId();
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/assets/" + asset_id;
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(asset);
        conn.addBodyPart("asset=" + json);
        asset = mapper.readValue(conn.getResponseBody(), Asset.class);
        conn.disconnect();
        return asset;
    }

    /******************************************************
     * Category
     ******************************************************/

    @Override
    public Category createCategory(int site_id, Category category) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/categories";
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(category);
        conn.addBodyPart("category=" + json);
        category = mapper.readValue(conn.getResponseBody(), Category.class);
        conn.disconnect();
        return category;
    }

    @Override
    public Category deleteCategory(int site_id, int category_id) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/categories/" + category_id;
        conn.connectUrl(url);
        conn.setRequestMethod("DELETE");
        ObjectMapper mapper = new ObjectMapper();
        Category category = mapper.readValue(conn.getResponseBody(), Category.class);
        conn.disconnect();
        return category;
    }

    @Override
    public Category getCategory(int site_id, int category_id, String fields) throws IOException {
        this.getToken();
        if (fields == null)
            fields = "";
        String url = endpoint + "/" + version + "/sites/" + site_id + "/categories/" + category_id + "?fields=" + fields;
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        Category category = mapper.readValue(conn.getResponseBody(), Category.class);
        conn.disconnect();
        return category;
    }

    @Override
    public CategoryItems searchCategory(CategorySearchParam search) throws IOException {
        this.getToken();
        int site_id = search.getSite_id();
        int entry_id = search.getEntry_id();
        String url;
        if ( site_id != 0 && entry_id != 0) {
            url = endpoint + "/" + version + "/sites/" + site_id + "/entries/"+ entry_id + "/categories?" + search.getQueryString();
        } else {
            url = endpoint + "/" + version + "/sites/" + site_id + "/categories?" + search.getQueryString();
        }
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        CategoryItems entries = mapper.readValue(conn.getResponseBody(), CategoryItems.class);
        conn.disconnect();
        return entries;
    }

    @Override
    public Category updateCategory(int site_id, Category category) throws IOException {
        int category_id = category.getId();
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/categories/" + category_id;
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(category);
        conn.addBodyPart("category=" + json);
        category = mapper.readValue(conn.getResponseBody(), Category.class);
        conn.disconnect();
        return category;
    }

    /******************************************************
     * User
     ******************************************************/

    @Override
    public User createUser(User user) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/users";
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        conn.addBodyPart("user=" + json);
        user = mapper.readValue(conn.getResponseBody(), User.class);
        conn.disconnect();
        return user;
    }

    @Override
    public User deleteUser(int user_id) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/users/" + user_id;
        conn.connectUrl(url);
        conn.setRequestMethod("DELETE");
        ObjectMapper mapper = new ObjectMapper();
        User deleteUser = mapper.readValue(conn.getResponseBody(), User.class);
        conn.disconnect();
        return deleteUser;
    }

    @Override
    public UserItems searchUser(UserSearchParam search) throws IOException {
        this.getToken();
        UserItems userItems = null;
        String url = endpoint + "/" + version + "/users?" + search.getQueryString();
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        userItems = mapper.readValue(conn.getResponseBody(), UserItems.class);
        conn.disconnect();
        return userItems;
    }

    @Override
    public User getUser(String user_id, String fields) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/users/" + user_id + "?fields=" + fields;
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(conn.getResponseBody(), User.class);
        conn.disconnect();
        return user;
    }

    @Override
    public User updateUser(User user) throws IOException {
        int user_id = Integer.valueOf(user.getId());
        this.getToken();
        String url = endpoint + "/" + version + "/users/" + user_id;
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        conn.addBodyPart("user=" + json);
        User updateUser = mapper.readValue(conn.getResponseBody(), User.class);
        conn.disconnect();
        return updateUser;
    }

    @Override
    public Status unlockUser(int user_id) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/users/" + user_id + "/unlock";
        conn.connectUrl(url);
        conn.setRequestMethod("POST");
        ObjectMapper mapper = new ObjectMapper();
        Status status = mapper.readValue(conn.getResponseBody(), Status.class);
        conn.disconnect();
        return status;
    }

    /******************************************************
     * Search
     ******************************************************/
    
    @Override
    public EntryItems search(SearchParam search) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/search?" + search.getQueryString();
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        EntryItems entries = mapper.readValue(conn.getResponseBody(), EntryItems.class);
        conn.disconnect();
        return entries;
    }

    /******************************************************
     * Template
     ******************************************************/

    @Override
    public Status rebuild(int site_id, int template_id) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/templates/" + template_id + "/publish";
        conn.connectUrl(url);
        conn.setRequestMethod("POST");
        ObjectMapper mapper = new ObjectMapper();
        Status status = mapper.readValue(conn.getResponseBody(), Status.class);
        conn.disconnect();
        return status;
    }

    @Override
    public Status resetAllTemplate(int site_id, String refresh_type) throws IOException {
        this.getToken();
        String refresh_type_query = new String();
        if ( refresh_type != null ) {
            refresh_type_query = "?refresh_type=" + refresh_type;
        }
        String url = endpoint + "/" + version + "/sites/" + site_id + "/refresh_templates" + refresh_type_query;
        conn.connectUrl(url);
        conn.setRequestMethod("POST");
        ObjectMapper mapper = new ObjectMapper();
        Status status = mapper.readValue(conn.getResponseBody(), Status.class);
        conn.disconnect();
        return status;
    }

    @Override
    public Status resetTemplate(int site_id, int template_id) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/templates/"+ template_id + "/refresh";
        conn.connectUrl(url);
        conn.setRequestMethod("POST");
        ObjectMapper mapper = new ObjectMapper();
        Status status = mapper.readValue(conn.getResponseBody(), Status.class);
        conn.disconnect();
        return status;
    }

    @Override
    public Template createTemplate(int site_id, Template template) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/templates";
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(template);
        conn.addBodyPart("template=" + json);
        template = mapper.readValue(conn.getResponseBody(), Template.class);
        conn.disconnect();
        return template;
    }

    @Override
    public Template updateTemplate(int site_id, Template template) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/templates/" + template.getId();
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(template);
        conn.addBodyPart("template=" + json);
        template = mapper.readValue(conn.getResponseBody(), Template.class);
        conn.disconnect();
        return template;
    }

    @Override
    public Template deleteTemplate(int site_id, int template_id) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/templates/" + template_id;
        conn.connectUrl(url);
        conn.setRequestMethod("DELETE");
        ObjectMapper mapper = new ObjectMapper();
        Template template = mapper.readValue(conn.getResponseBody(), Template.class);
        conn.disconnect();
        return template;
    }

    @Override
    public TemplateItems searchTemplate(TemplateSearchParam search) throws IOException {
        this.getToken();
        int site_id = search.getSite_id();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/templates?" + search.getQueryString();
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        TemplateItems templates = mapper.readValue(conn.getResponseBody(), TemplateItems.class);
        conn.disconnect();
        return templates;
    }

    /******************************************************
     * Theme
     ******************************************************/

    @Override
    public ThemeItems getThemeList() throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/themes";
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        ThemeItems themes = mapper.readValue(conn.getResponseBody(), ThemeItems.class);
        conn.disconnect();
        return themes;
    }

    @Override
    public Theme getTheme(String theme_id) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/themes/" + theme_id;
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        Theme theme = mapper.readValue(conn.getResponseBody(), Theme.class);
        conn.disconnect();
        return theme;
    }

    @Override
    public Status applyTheme(int site_id, String theme_id) throws IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/themes/" + theme_id + "/apply";
        conn.connectUrl(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        ObjectMapper mapper = new ObjectMapper();
        Status status = mapper.readValue(conn.getResponseBody(), Status.class);
        conn.disconnect();
        return status;
    }

    /******************************************************
     * Folder
     ******************************************************/

    @Override
    public FolderItems searchFolder(FolderSearchParam search) throws IOException {
        this.getToken();
        int site_id = search.getSite_id();
        String url = endpoint + "/" + version + "/sites/"+ site_id + "/folders?" + search.getQueryString();
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        FolderItems folders = mapper.readValue(conn.getResponseBody(), FolderItems.class);
        conn.disconnect();
        return folders;
    }

    @Override
    public FolderItems searchParentsFolder(int site_id, int folder_id, int maxDepth, int includeCurrent) throws IOException {
        this.getToken();
        String query = "includeCurrent=" + includeCurrent;
        if ( maxDepth != 0 ) {
            query = query + "&maxDepth=" + maxDepth;
        }
        String url = endpoint + "/" + version + "/sites/" + site_id + "/folders/" + folder_id + "/parents?" + query;
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        FolderItems folders = mapper.readValue(conn.getResponseBody(), FolderItems.class);
        conn.disconnect();
        return folders;
    }

    @Override
    public FolderItems searchSiblingsFolder(FolderSearchParam search) throws IOException {
        this.getToken();
        int site_id = search.getSite_id();
        int folder_id = search.getFolder_id();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/folders/" + folder_id + "/siblings?" + search.getQueryString();
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        FolderItems folders = mapper.readValue(conn.getResponseBody(), FolderItems.class);
        conn.disconnect();
        return folders;
    }

    @Override
    public FolderItems searchChildFolder(int site_id, int folder_id, int maxDepth, int includeCurrent) throws IOException {
        this.getToken();
        String query = "includeCurrent=" + includeCurrent;
        if ( maxDepth != 0 ) {
            query = query + "&maxDepth=" + maxDepth;
        }
        String url = endpoint + "/" + version + "/sites/" + site_id + "/folders/" + folder_id + "/siblings?" + query;
        conn.connectUrl(url);
        conn.setRequestMethod("GET");
        ObjectMapper mapper = new ObjectMapper();
        FolderItems folders = mapper.readValue(conn.getResponseBody(), FolderItems.class);
        conn.disconnect();
        return folders;
    }
}