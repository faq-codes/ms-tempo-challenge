package com.faq.suba.models;

public class HistoryInputModel {

  private final String endpoint;
  private final String request;
  private final String response;

  public String getEndpoint() {
    return endpoint;
  }

  public String getRequest() {
    return request;
  }

  public String getResponse() {
    return response;
  }

  public HistoryInputModel(String endpoint, String request, String response) {
    this.endpoint = endpoint;
    this.request = request;
    this.response = response;
  }

}
