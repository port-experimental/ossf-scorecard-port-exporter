package io.port;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;

@RegisterRestClient()
public interface ScorecardService {

    @GET
    ScorecardReport getScorecard();
}
