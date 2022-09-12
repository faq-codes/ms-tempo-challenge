package com.faq.suba.adapters.gateways;

import org.springframework.cache.annotation.Cacheable;

public interface GetPercentGateway {

  @Cacheable("percent")  
  double getPercent();

}
