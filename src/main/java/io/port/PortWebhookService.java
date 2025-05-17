package io.port;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;

@RegisterRestClient()
public interface PortWebhookService {
    
    @POST
    void pushScorecard(ScorecardReport scorecard, @HeaderParam("Authorization") String authorization);

}
