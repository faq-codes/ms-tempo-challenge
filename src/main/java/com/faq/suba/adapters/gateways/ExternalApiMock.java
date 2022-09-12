package com.faq.suba.adapters.gateways;

public class ExternalApiMock implements ExternalApiGateway {

  @Override
  public double get() {
    return 10.0D;
  }
  
}
