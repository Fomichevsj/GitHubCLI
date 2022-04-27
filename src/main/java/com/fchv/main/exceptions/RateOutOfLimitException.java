package com.fchv.main.exceptions;

import org.kohsuke.github.GHRateLimit;

public class RateOutOfLimitException extends RuntimeException {

    public RateOutOfLimitException(GHRateLimit rateLimit) {
        super("Limit of requests is reached. Use either token or try later, after "
                + rateLimit.getResetDate());
    }
}
