package com.faq.suba.models;

import java.time.LocalDateTime;

public class HistoryDataModel {

  private final LocalDateTime date;
  private final String endpoint;
  private final String request;
  private final String response;

  public LocalDateTime getDate() {
    return date;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public String getRequest() {
    return request;
  }

  public String getResponse() {
    return response;
  }

  public HistoryDataModel(LocalDateTime date, String endpoint, String request, String response) {
    this.date = date;
    this.endpoint = endpoint;
    this.request = request;
    this.response = response;
  }

}
