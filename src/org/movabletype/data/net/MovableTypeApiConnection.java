package org.movabletype.data.net;

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

public class MovableTypeApiConnection {

    public HttpURLConnection urlconn = null;
    public String useragent = "MovableType DataAPI Java Client/v3";

    /**
     * @param url
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws IOException
     */
    public MovableTypeApiConnection(String url) throws NoSuchAlgorithmException, KeyManagementException, IOException {
        URL connectURL = new URL(url);
        if ("https".equals(connectURL.getProtocol())) {
            // Cert info
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
            // Check host
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
        urlconn.setRequestProperty("User-Agent", useragent);
        urlconn.setInstanceFollowRedirects(false);
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

    public void addBodyPart(String body) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(urlconn.getOutputStream());
        writer.write(body);
        writer.flush();
    }

    public String getUserAgent() {
        return useragent;
    }

}
