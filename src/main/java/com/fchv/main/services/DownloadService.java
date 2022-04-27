package com.fchv.main.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fchv.main.commands.AbstractGithubCommand;
import com.fchv.main.exceptions.RepositoryNotFoundException;
import com.fchv.main.github.GitHubProvider;
import com.fchv.main.model.DownloadDto;
import com.fchv.main.writers.OutputWriter;
import com.fchv.main.writers.WriterProvider;
import me.tongfei.progressbar.ProgressBar;
import org.kohsuke.github.GHFileNotFoundException;
import org.kohsuke.github.GHRelease;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

public class DownloadService {

    public void downloads(AbstractGithubCommand downloadCommand) {
        String repo = downloadCommand.getRepo();
        String filePath = downloadCommand.getFilePath();
        try {
            GitHub github = GitHubProvider.gitHub(downloadCommand);
            List<DownloadDto> distributions = getDistributions(repo, github);
            if (distributions.size() > 0) {
                printTable(distributions, filePath);
            } else {
                System.out.println("no asset for this repository");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<DownloadDto> getDistributions(String repo, GitHub github) throws IOException {
        List<DownloadDto> distributions = new ArrayList<>();
        GHRepository gHRepo;
        try {
            gHRepo = github.getRepository(repo);
        } catch (GHFileNotFoundException notFoundException) {
            throw new RepositoryNotFoundException(repo);
        }

        var releases = gHRepo.listReleases().toList();
        try (ProgressBar pb = new ProgressBar("Fetch assets", releases.size())) {
            for (GHRelease release : releases) {
                var assets = release.listAssets().toList();
                distributions.addAll(assets.stream().map(asset -> new DownloadDto(release.getName(),
                                asset.getName(),
                                asset.getDownloadCount()))
                        .collect(Collectors.toList()));
                pb.step(); // step by 1
                pb.setExtraMessage("Reading...");
            }
        }
        return distributions;
    }

    private void printTable(List<DownloadDto> distributions, String filePath) {
        long totalDownloads = 0;
        String[][] data = new String[distributions.size() + 1][3];
        for (int i = 0; i < distributions.size(); i++) {
            var downloadDto = distributions.get(i);
            data[i][0] = downloadDto.getReleaseName();
            data[i][1] = downloadDto.getDistributionName();
            data[i][2] = String.valueOf(downloadDto.getDownloadsCount());
            totalDownloads += downloadDto.getDownloadsCount();
        }
        data[distributions.size()][0] = "TOTAL AMOUNT";
        data[distributions.size()][1] = "";
        data[distributions.size()][2] = String.valueOf(totalDownloads);
        OutputWriter writer = WriterProvider.getWriterFor(filePath);
        writer.writeTable(new String[] {"Release name", "Distribution", "Download count"}, data);
    }
}
