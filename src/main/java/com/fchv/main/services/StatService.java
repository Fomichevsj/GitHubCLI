package com.fchv.main.services;

import java.io.IOException;

import com.fchv.main.commands.StatCommand;
import com.fchv.main.exceptions.RepositoryNotFoundException;
import com.fchv.main.github.GitHubProvider;
import com.fchv.main.model.StatsDto;
import com.fchv.main.writers.OutputWriter;
import com.fchv.main.writers.WriterProvider;
import org.kohsuke.github.GHFileNotFoundException;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class StatService {

    public void stat(StatCommand statCommand) {
        String repo = statCommand.getRepo();
        String filePath = statCommand.getFilePath();
        try {
            GitHub github = GitHubProvider.gitHub(statCommand);
            GHRepository gHrepo;
            try {
                gHrepo = github.getRepository(repo);
            } catch (GHFileNotFoundException notFoundException) {
                throw new RepositoryNotFoundException(repo);
            }
            var statsDto = new StatsDto(gHrepo.getStargazersCount(),
                    gHrepo.getForksCount(),
                    gHrepo.listContributors().toList().size(),
                    gHrepo.getLanguage());
            printTable(statsDto, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void printTable(StatsDto statsDto, String filePath) {
        String[][] data = new String[4][2];

        data[0][0] = "stars";
        data[0][1] = String.valueOf(statsDto.getStarsCount());
        data[1][0] = "forks";
        data[1][1] = String.valueOf(statsDto.getForksCount());
        data[2][0] = "contributors";
        data[2][1] = String.valueOf(statsDto.getContributorsCount());
        data[3][0] = "language";
        data[3][1] = statsDto.getLanguage();

        OutputWriter outputWriter = WriterProvider.getWriterFor(filePath);
        outputWriter.writeTable(new String[] {"stat", "value"}, data);
    }
}
