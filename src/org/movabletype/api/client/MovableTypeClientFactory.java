package org.movabletype.api.client;

import java.io.IOException;

public abstract class MovableTypeClientFactory {

    /**
     * MovableTypeApiClient
     * 
     * @param username
     * @param password
     * @param clientId
     * @param endpoint
     * @return
     * @throws IOException
     */
    public static MovableTypeApiClient createDataApiClient(String username, String password, String clientId, String endpoint) throws IOException {
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
     * @throws IOException
     */
    public static MovableTypeApiClient createDataApiClient(String username, String password, String clientId, String endpoint, String authUsername,
            String authPassword) throws IOException {
        return new MovableTypeApiClientImpl(username, password, clientId, endpoint, authUsername, authPassword);
    }

    /**
     * MovableTypeApiClient - Connection not authenticated
     * 
     * @param clientId
     * @param endpoint
     * @return
     * @throws IOException
     */
    public static MovableTypeApiClient createDataApiClient(String clientId, String endpoint)
            throws IOException {
        return new MovableTypeApiClientImpl(clientId, endpoint);
    }
}
