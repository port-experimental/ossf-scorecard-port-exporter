package io.port;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.scheduler.Scheduled;


public class Scheduler {

    @RestClient
    ScorecardService scorecardService;

    @RestClient
    PortWebhookService portWebhookService;

    @RestClient
    PortClient portClient;

    @ConfigProperty(name="port.scheduler.frequency")
    String scheduleFrequency;

    @ConfigProperty(name="port.client.id")
    String clientId;

    @ConfigProperty(name="port.client.secret")
    String clientSecret;
    
    @Scheduled(every = "${port.scheduler.frequency}")
    public void pullAndPushScorecard() {
           ScorecardReport scorecard = scorecardService.getScorecard();
        String token = portClient.getToken(new PortCredentials(clientId, clientSecret)).get("accessToken").toString(); 
        portWebhookService.pushScorecard(scorecard, "Bearer " + token);
    }
}
