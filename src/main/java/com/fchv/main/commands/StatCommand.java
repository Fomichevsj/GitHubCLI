package com.fchv.main.commands;

import com.fchv.main.services.StatService;
import picocli.CommandLine;

@CommandLine.Command(
        name = "stats",
        description = "will fetch the following information: stars, forks, contributors, language",
        mixinStandardHelpOptions = true
)
public class StatCommand extends AbstractGithubCommand implements Runnable {

    @Override
    public void run() {
        StatService statService = new StatService();
        statService.stat(this);
    }

}
