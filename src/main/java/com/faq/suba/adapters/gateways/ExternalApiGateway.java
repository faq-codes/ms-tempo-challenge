package com.faq.suba.adapters.gateways;

import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.retry.annotation.Backoff;

public interface ExternalApiGateway {

  @Retryable(
    value = { Exception.class }, 
    maxAttemptsExpression = "${spring.retry.maxAttempts}", 
    backoff = @Backoff(delayExpression = "${spring.retry.delay}"))
  double get() throws Exception;

}
