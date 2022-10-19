package com.juarodriguezc.api.requestModels;

import java.util.List;

public class EpisodeResponseAPI {
    private List<EpisodeAPI> results;

    public List<EpisodeAPI> getResults() {
        return results;
    }

    public void setResults(List<EpisodeAPI> results) {
        this.results = results;
    }
}
