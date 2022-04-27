package com.fchv.main.model;

public class DownloadDto {

    private final String releaseName;

    private final String distributionName;

    private final long downloadsCount;

    public DownloadDto(String releaseName, String distributionName, long downloadsCount) {
        this.releaseName = releaseName;
        this.distributionName = distributionName;
        this.downloadsCount = downloadsCount;
    }

    public String getReleaseName() {
        return releaseName;
    }

    public String getDistributionName() {
        return distributionName;
    }

    public long getDownloadsCount() {
        return downloadsCount;
    }

}
