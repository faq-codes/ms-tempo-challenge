package com.faq.suba.entities;

import java.time.LocalDateTime;

public class HistoryEntity implements History {

  private final int id;
  private final LocalDateTime date;
  private final String endpoint;
  private final String request;
  private final String response;

  public HistoryEntity(String endpoint, String request, String response) {
    this.id = 0;
    this.date = LocalDateTime.now();
    this.endpoint = endpoint;
    this.request = request;
    this.response = response;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public LocalDateTime getDate() {
    return date;
  }

  @Override
  public String getEndpoint() {
    return endpoint;
  }

  @Override
  public String getRequest() {
    return request;
  }

  @Override
  public String getResponse() {
    return response;
  }

}
