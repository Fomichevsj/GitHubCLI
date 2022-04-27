package com.fchv.main.model;

public class StatsDto {

    private final long starsCount;

    private final long forksCount;

    private final long contributorsCount;

    private final String language;

    public StatsDto(long starsCount, long forksCount, long contributorsCount, String language) {
        this.starsCount = starsCount;
        this.forksCount = forksCount;
        this.contributorsCount = contributorsCount;
        this.language = language;
    }

    public long getStarsCount() {
        return starsCount;
    }

    public long getForksCount() {
        return forksCount;
    }

    public long getContributorsCount() {
        return contributorsCount;
    }

    public String getLanguage() {
        return language;
    }

}
