package com.fchv.main.exceptions;

public class RepositoryNotFoundException extends RuntimeException {

    public RepositoryNotFoundException(String repo) {
        super("The repository " + repo + " not found");
    }
}
