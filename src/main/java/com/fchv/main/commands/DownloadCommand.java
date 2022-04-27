package com.fchv.main.commands;

import com.fchv.main.services.DownloadService;
import picocli.CommandLine;

@CommandLine.Command(
        name = "downloads",
        description = "will fetch the # of downloads of the entire versions + distributions (if exists)",
        mixinStandardHelpOptions = true
)
public class DownloadCommand extends AbstractGithubCommand implements Runnable {

    @Override
    public void run() {
        DownloadService downloadService = new DownloadService();
        downloadService.downloads(this);
    }

}
