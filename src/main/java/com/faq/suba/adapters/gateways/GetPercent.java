package com.faq.suba.adapters.gateways;

public class GetPercent implements GetPercentGateway {

  ExternalApiGateway externalApi;

  public GetPercent(ExternalApiGateway externalApi) {
    this.externalApi = externalApi;
  }

  @Override
  public double getPercent() {
    return externalApi.get();
  }
  
}
