package com.fchv.main.github;

import java.io.IOException;

import com.fchv.main.commands.AbstractGithubCommand;
import com.fchv.main.exceptions.RateOutOfLimitException;
import org.kohsuke.github.GitHub;

public class GitHubProvider {

    /**
     *
     * @param command command
     * @return gitHub entity for request to GitHubApi
     * @throws IOException
     */
    public static GitHub gitHub(AbstractGithubCommand command) throws IOException {
        if (command.getToken() != null) {
            return GitHub.connectUsingOAuth(command.getToken());
        } else {
            var gitHub = GitHub.connectAnonymously();
            if (gitHub.getRateLimit().getRemaining() <= 0) {
                throw new RateOutOfLimitException(gitHub.getRateLimit());
            } else {
                return gitHub;
            }
        }
    }
}
