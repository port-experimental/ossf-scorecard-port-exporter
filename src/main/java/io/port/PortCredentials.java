package io.port;

public class PortCredentials {
    private String clientId;
    private String clientSecret;

    public PortCredentials(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

        
}
