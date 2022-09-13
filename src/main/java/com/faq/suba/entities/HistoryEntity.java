package com.faq.suba.entities;

import java.time.LocalDate;

public class HistoryEntity implements History {

  private final int id;
  private final LocalDate date;
  private final String endpoint;
  private final String request;
  private final String response;

  public HistoryEntity(String endpoint, String request, String response) {
    this.id = 0;
    this.date = LocalDate.now();
    this.endpoint = endpoint;
    this.request = request;
    this.response = response;
  }

}
