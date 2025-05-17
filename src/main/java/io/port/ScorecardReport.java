package io.port;

import java.util.List;

public class ScorecardReport {
    private List<Check> checks;
    private String date;
    private String metadata;
    private Repo repo;
    private double score;
    private Scorecard scorecard;

    // Getters and Setters
    public List<Check> getChecks() { return checks; }
    public void setChecks(List<Check> checks) { this.checks = checks; }
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
    public String getMetadata() { return metadata; }
    public void setMetadata(String metadata) { this.metadata = metadata; }
    public Repo getRepo() { return repo; }
    public void setRepo(Repo repo) { this.repo = repo; }
    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }
    public Scorecard getScorecard() { return scorecard; }
    public void setScorecard(Scorecard scorecard) { this.scorecard = scorecard; }

    public static class Check {
        private List<String> details;
        private Documentation documentation;
        private String name;
        private String reason;
        private int score;

        // Getters and Setters
        public List<String> getDetails() { return details; }
        public void setDetails(List<String> details) { this.details = details; }
        public Documentation getDocumentation() { return documentation; }
        public void setDocumentation(Documentation documentation) { this.documentation = documentation; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getReason() { return reason; }
        public void setReason(String reason) { this.reason = reason; }
        public int getScore() { return score; }
        public void setScore(int score) { this.score = score; }
    }

    public static class Documentation {
        private String shortDescription;
        private String url;

        // Getters and Setters
        public String getShortDescription() { return shortDescription; }
        public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }
        public String getUrl() { return url; }
        public void setUrl(String url) { this.url = url; }
    }

    public static class Repo {
        private String commit;
        private String name;

        // Getters and Setters
        public String getCommit() { return commit; }
        public void setCommit(String commit) { this.commit = commit; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }

    public static class Scorecard {
        private String commit;
        private String version;

        // Getters and Setters
        public String getCommit() { return commit; }
        public void setCommit(String commit) { this.commit = commit; }
        public String getVersion() { return version; }
        public void setVersion(String version) { this.version = version; }
    }
}
