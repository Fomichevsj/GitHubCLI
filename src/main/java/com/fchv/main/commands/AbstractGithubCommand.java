package com.fchv.main.commands;

import picocli.CommandLine;

public class AbstractGithubCommand {
    @CommandLine.Option(
            names = {"-r", "--repo"},
            description = "The repository to analyze",
            required = true
    )
    protected String repo;

    @CommandLine.Option(
            names = {"-o", "--output"},
            description = "The output path of the txt file"
    )
    protected String filePath;

    @CommandLine.Option(
            names = {"-t", "--token"},
            description = "The token for GitHub"
    )
    protected String token;

    public String getRepo() {
        return repo;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getToken() {
        return token;
    }

}
