package org.movabletype.data.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.movabletype.data.api.pojo.AddUser;
import org.movabletype.data.api.pojo.Asset;
import org.movabletype.data.api.pojo.Authentication;
import org.movabletype.data.api.pojo.Entry;
import org.movabletype.data.api.pojo.EntryItems;
import org.movabletype.data.api.pojo.Site;
import org.movabletype.data.api.pojo.SiteItems;
import org.movabletype.data.api.pojo.Status;
import org.movabletype.data.api.pojo.Token;
import org.movabletype.data.api.pojo.User;
import org.movabletype.data.api.pojo.UserItems;
import org.movabletype.data.api.pojo.Version;
import org.movabletype.data.api.request.EntrySearchParam;
import org.movabletype.data.api.request.SiteSearchParam;
import org.movabletype.data.api.request.UploadParam;
import org.movabletype.data.api.request.UserSearchParam;
import org.movabletype.data.exception.MovableTypeArgumentException;
import org.movabletype.data.net.MovableTypeApiConnection;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
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
    public Version getVersion() throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        Version apiversion = null;
        String url = endpoint + "/" + version + "/version";
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("GET");
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        apiversion = mapper.readValue(conn.getResponseBody(), Version.class);
        conn.disconnect();
        return apiversion;
    }

    @Override
    public int getResponseCode() throws IOException {
        return conn.getResponseCode();
    }

    @Override
    public String getResponseMessage() throws IOException {
        return conn.getResponseMessage();
    }

    @Override
    public String getResponseBody() throws IOException {
        return conn.getResponseBody();
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
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     */
    public MovableTypeApiClientImpl(String username, String password, String clientId, String endpoint) throws JsonParseException, JsonMappingException,
            IOException, KeyManagementException, NoSuchAlgorithmException {
        this.endpoint = endpoint;
        expire = 0L;
        version = "v3";
        String url = endpoint + "/" + version + "/authentication?username=" + username + "&password=" + password + "&clientId=" + clientId;
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("POST");
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        authentication = mapper.readValue(conn.getResponseBody(), Authentication.class);
        conn.disconnect();
    }

    /**
     * getToken
     * 
     * @return Token
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    private Token getToken() throws KeyManagementException, NoSuchAlgorithmException, IOException {
        Long now = System.currentTimeMillis() / 1000L;
        if (expire > now) {
            // System.out.println("reuse session");
            return token;
        }
        // System.out.println("get session");
        String url = endpoint + "/" + version + "/token";
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth sessionId=" + authentication.getSessionId());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        token = mapper.readValue(conn.getResponseBody(), Token.class);
        conn.disconnect();
        expire = System.currentTimeMillis() / 1000L + token.getExpiresIn();
        return token;
    }

    @Override
    public Authentication getAuthentication() {
        return authentication;
    }

    @Override
    public Status signOut() throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/authentication";

        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("DELETE");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        Status status = mapper.readValue(conn.getResponseBody(), Status.class);
        conn.disconnect();
        return status;
    }

    @Override
    public Status deleteToken() throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/token";

        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("DELETE");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        Status status = mapper.readValue(conn.getResponseBody(), Status.class);
        conn.disconnect();
        expire = 0;
        return status;
    }

    /******************************************************
     * Site
     * 
     * @throws IOException
     ******************************************************/
    @Override
    public Site createWebsite(Site site) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites";
        conn = new MovableTypeApiConnection(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(site);
        conn.addBodyPart("website=" + json);
        conn.connect();
        Site createSite = mapper.readValue(conn.getResponseBody(), Site.class);
        conn.disconnect();
        return createSite;
    }

    @Override
    public Site createBlog(int site_id, Site site) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id;
        conn = new MovableTypeApiConnection(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(site);
        conn.addBodyPart("blog=" + json);
        conn.connect();
        conn.getResponseBody();
        Site createSite = mapper.readValue(conn.getResponseBody(), Site.class);
        conn.disconnect();
        return createSite;
    }

    @Override
    public Site deleteSite(int id) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + id;
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("DELETE");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        Site deleteSite = mapper.readValue(conn.getResponseBody(), Site.class);
        conn.disconnect();
        return deleteSite;
    }

    @Override
    public SiteItems getSites(SiteSearchParam siteSearchParam) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites?" + siteSearchParam.getQueryString();
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("GET");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        SiteItems siteItems = mapper.readValue(conn.getResponseBody(), SiteItems.class);
        conn.disconnect();
        return siteItems;
    }

    /******************************************************
     * Entry
     ******************************************************/
    @Override
    public Entry postEntry(int site_id, Entry entry) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/entries";
        conn = new MovableTypeApiConnection(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(entry);
        conn.addBodyPart("entry=" + json);
        conn.connect();
        Entry postedEntry = mapper.readValue(conn.getResponseBody(), Entry.class);
        conn.disconnect();
        return postedEntry;
    }

    @Override
    public Entry deleteEntry(int site_id, Integer entry_id) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/entries/" + entry_id;
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("DELETE");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        Entry deleteEntry = mapper.readValue(conn.getResponseBody(), Entry.class);
        conn.disconnect();
        return deleteEntry;
    }

    @Override
    public EntryItems getEntries(int site_id) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/entries";
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("GET");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        EntryItems entries = mapper.readValue(conn.getResponseBody(), EntryItems.class);
        conn.disconnect();
        return entries;
    }

    @Override
    public EntryItems searchEntry(EntrySearchParam search) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        // TODO Auto-generated method stub
        if (search.getSearch() == null) {
            throw new MovableTypeArgumentException("Search parameter is required");
        }
        this.getToken();
        String url = endpoint + "/" + version + "/search?" + search.getQueryString();
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("GET");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        EntryItems entries = mapper.readValue(conn.getResponseBody(), EntryItems.class);
        conn.disconnect();
        return entries;
    }

    /******************************************************
     * Asset
     ******************************************************/
    @SuppressWarnings("rawtypes")
    @Override
    public Asset uploadAsset(UploadParam upload) throws IOException, KeyManagementException, NoSuchAlgorithmException {
        this.getToken();

        String overwrite = "";
        if (upload.isOverwrite_once() == true)
            overwrite = "?overwrite_once=1";
        String url = endpoint + "/" + version + "/assets/upload" + overwrite;
        Asset asset = null;
        String CRLF = "\r\n";
        String charset = "UTF-8";
        String boundary = "---------------------------" + Long.toString(System.currentTimeMillis());
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.addRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);
        conn.connect();
        OutputStream outputStream = conn.getOutputStream();
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, charset), true);
        HashMap<String, Comparable> requestBody = new HashMap<String, Comparable>();
        requestBody.put("site_id", upload.getSite_id());
        requestBody.put("path", upload.getUploadPath());
        requestBody.put("autoRenameIfExists", upload.isAutoRenameIfExists());
        requestBody.put("normalizeOrientation", upload.isNormalizeOrientation());
        for (java.util.Map.Entry<String, Comparable> req : requestBody.entrySet()) {// [9]
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
    public Asset deleteAsset(int site_id, int asset_id) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/sites/" + site_id + "/assets/" + asset_id;
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("DELETE");

        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        Asset asset = mapper.readValue(conn.getResponseBody(), Asset.class);
        conn.disconnect();

        return asset;
    }

    /******************************************************
     * User
     ******************************************************/
    @Override
    public User createUser(AddUser addUser) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/users";
        conn = new MovableTypeApiConnection(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(addUser);
        conn.addBodyPart("user=" + json);
        conn.connect();
        User createUser = mapper.readValue(conn.getResponseBody(), User.class);
        conn.disconnect();
        return createUser;
    }

    @Override
    public User deleteUser(int user_id) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/users/" + user_id;
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("DELETE");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        User deleteUser = mapper.readValue(conn.getResponseBody(), User.class);
        conn.disconnect();
        return deleteUser;
    }

    @Override
    public UserItems searchUser(UserSearchParam search) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        // TODO Auto-generated method stub
        if (search.getSearch() == null) {
            throw new MovableTypeArgumentException("Search parameter is required");
        }

        this.getToken();
        UserItems userItems = null;
        String url = endpoint + "/" + version + "/users?" + search.getQueryString();

        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("GET");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        userItems = mapper.readValue(conn.getResponseBody(), UserItems.class);
        conn.disconnect();

        return userItems;
    }

    @Override
    public User getUser(String user_id, String fields) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/users/" + user_id + "?" + fields;
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("GET");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(conn.getResponseBody(), User.class);
        conn.disconnect();
        return user;
    }

    @Override
    public User updateUser(int user_id, User user) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "/users/" + user_id;
        conn = new MovableTypeApiConnection(url);
        conn.setDoOutput(true);
        conn.setRequestMethod("PUT");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        conn.addBodyPart("user=" + json);
        conn.connect();
        User updateUser = mapper.readValue(conn.getResponseBody(), User.class);
        conn.disconnect();
        return updateUser;
    }

    @Override
    public Status unlockUser(int user_id) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        this.getToken();
        String url = endpoint + "/" + version + "//users/" + user_id + "/unlock";
        conn = new MovableTypeApiConnection(url);
        conn.setRequestMethod("POST");
        conn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        conn.connect();
        ObjectMapper mapper = new ObjectMapper();
        Status status = mapper.readValue(conn.getResponseBody(), Status.class);
        conn.disconnect();
        return status;
    }
}
