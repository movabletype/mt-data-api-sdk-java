package org.movabletype.api.client;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

public abstract class MovableTypeClientFactory {

    /**
     * MovableTypeApiClient
     * 
     * @param username
     * @param password
     * @param clientId
     * @param endpoint
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static MovableTypeApiClient createDataApiClient(String username, String password, String clientId, String endpoint) throws JsonParseException,
            JsonMappingException, KeyManagementException, NoSuchAlgorithmException, IOException {
        return new MovableTypeApiClientImpl(username, password, clientId, endpoint);
    }

    /**
     * MovableTypeApiClient - Basic Authentication
     * 
     * @param username
     * @param password
     * @param clientId
     * @param endpoint
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static MovableTypeApiClient createDataApiClient(String username, String password, String clientId, String endpoint, String authUsername,
            String authPassword) throws JsonParseException, JsonMappingException, KeyManagementException, NoSuchAlgorithmException, IOException {
        return new MovableTypeApiClientImpl(username, password, clientId, endpoint, authUsername, authPassword);
    }

    /**
     * MovableTypeApiClient - Connection not authenticated
     * 
     * @param clientId
     * @param endpoint
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static MovableTypeApiClient createDataApiClient(String clientId, String endpoint)
            throws JsonParseException, JsonMappingException, KeyManagementException, NoSuchAlgorithmException, IOException {
        return new MovableTypeApiClientImpl(clientId, endpoint);
    }
}
