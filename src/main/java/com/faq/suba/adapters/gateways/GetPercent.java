package com.faq.suba.adapters.gateways;

public class GetPercent implements GetPercentGateway {

  ExternalApiGateway externalApi;

  public GetPercent(ExternalApiGateway externalApi) {
    this.externalApi = externalApi;
  }

  @Override
  public double getPercent() {
    try {
      return externalApi.get();  
    } catch (Exception e) {
      System.out.println("ERROR API EXTERNA" + e.getMessage());
      return 0D;
    }    
  }
  
}
