package com.github.movabletype.data.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.github.movabletype.data.api.pojo.Token;
import org.apache.commons.codec.binary.Base64;

public class MovableTypeApiConnection {

    private HttpURLConnection urlconn;

    private Token token;
    private String authUsername;
    private String authPassword;
    private String useragent = "MovableType DataAPI Java Client/v3";

    /*
     * MovableTypeApiConnection
     */
    public MovableTypeApiConnection() {
        super();
    }

    /**
     * connectUrl
     * 
     * @param url
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public void connectUrl(String url) throws IOException, NoSuchAlgorithmException, KeyManagementException {
        URL connectURL = new URL(url);
        if ("https".equals(connectURL.getProtocol())) {
            // Certificate information return all empty
            TrustManager[] tm = { new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }

                @Override
                public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                }
            } };
            SSLContext sslcontext = SSLContext.getInstance("SSL");
            sslcontext.init(null, tm, null);
            // Host name verification rule Return true if anything comes in
            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                @Override
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
            urlconn = (HttpsURLConnection) connectURL.openConnection();
            ((HttpsURLConnection) urlconn).setSSLSocketFactory(sslcontext.getSocketFactory());
        } else {
            urlconn = (HttpURLConnection) connectURL.openConnection();
        }
        if (authUsername != null && authPassword != null) {
            String auth = authUsername + ":" + authPassword;
            urlconn.setRequestProperty("Authorization", "Basic " + Base64.encodeBase64(auth.getBytes()));
        }
        if (token != null) {
            urlconn.addRequestProperty("X-MT-Authorization", "MTAuth accessToken=" + token.getAccessToken());
        }
        urlconn.setRequestProperty("User-Agent", useragent);
        urlconn.setInstanceFollowRedirects(false);
    }

    /**
     * setToken
     * 
     * @param token
     */
    public void setToken(Token token) {
        this.token = token;
    }

    /**
     * setBasicAuthentication
     * 
     * @param authUsername
     * @param authPassword
     */
    public void setBasicAuthentication(String authUsername, String authPassword) {
        this.authUsername = authUsername;
        this.authPassword = authPassword;
    }

    /**
     * getResponseBody
     * 
     * @return Response Body
     * @throws IOException
     */
    public String getResponseBody() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "utf8"));
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        return sb.toString();
    }

    /**
     * addBodyPart
     * 
     * @param body
     * @throws IOException
     */
    public void addBodyPart(String body) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(urlconn.getOutputStream());
        writer.write(body);
        writer.flush();
    }

    /**
     * getUserAgent
     * 
     * @return
     */
    public String getUserAgent() {
        return useragent;
    }

    public void setRequestMethod(String method) throws ProtocolException {
        urlconn.setRequestMethod(method);
    }

    public void connect() throws IOException {
        urlconn.connect();
    }

    public void disconnect() throws IOException {
        urlconn.disconnect();
    }

    public InputStream getInputStream() throws IOException {
        return urlconn.getInputStream();
    }

    public int getResponseCode() throws IOException {
        return urlconn.getResponseCode();
    }

    public OutputStream getOutputStream() throws IOException {
        return urlconn.getOutputStream();
    }

    public String getResponseMessage() throws IOException {
        return urlconn.getResponseMessage();
    }

    public void setDoOutput(boolean dooutput) {
        urlconn.setDoOutput(dooutput);
    }

    public void addRequestProperty(String key, String value) {
        urlconn.addRequestProperty(key, value);
    }

    public void setUseCaches(boolean cache) {
        urlconn.setUseCaches(cache);
    }

    public void setDoInput(boolean doinput) {
        urlconn.setDoInput(doinput);
    }

    public void setRequestProperty(String key, String value) {
        urlconn.setRequestProperty(key, value);
    }
}
