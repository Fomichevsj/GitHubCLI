package com.fchv.main.commands;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;

@Command(
        name = "GitHubCLI",
        synopsisHeading = "This tool is used to get some stats from Github for specific repo\n" +
                "This tool present the result as a table and write the output for a given\n" +
                "file or just print it\n\nUsage:\n",
        subcommands = {DownloadCommand.class, StatCommand.class, CommandLine.HelpCommand.class},
        mixinStandardHelpOptions = true,
        version = "v.1.0"
)
public class GitHubCLICommand {
    @Spec
    CommandSpec spec;

    public static void main(String[] args) {
        int exitCode = new CommandLine(new GitHubCLICommand()).execute(args);
        System.exit(exitCode);
    }
}
