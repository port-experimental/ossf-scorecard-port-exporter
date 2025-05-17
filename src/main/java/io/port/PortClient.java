package io.port;

import java.util.Map;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;


import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterRestClient(baseUri = "https://api.getport.io/v1")
public interface PortClient {

    @POST
    @Path("/auth/access_token")
    @Produces(MediaType.APPLICATION_JSON)
    Map<String, Object>  getToken(PortCredentials credentials);
    
}
