package com.adc.order.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
abstract class AbstractCircuitBreakFallbackHandler {
    protected <T> T handleTypedFallback(Throwable throwable) throws Throwable {
        handleError(throwable);
        return null;
    }

    private void handleError(Throwable throwable) throws Throwable {
        log.error("Circuit breaker records an error. Detail {}", throwable.getMessage());
        throw throwable;
    }
}
