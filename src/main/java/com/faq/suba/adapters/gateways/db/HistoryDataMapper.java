package com.faq.suba.adapters.gateways.db;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "history")
public class HistoryDataMapper {
  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "date")
  private LocalDateTime date;
  @Column(name = "endpoint")
  private String endpoint;
  @Column(name = "request")
  private String request;
  @Column(name = "response")
  private String response;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getRequest() {
    return request;
  }

  public void setRequest(String request) {
    this.request = request;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public HistoryDataMapper() {
    super();
  }

  public HistoryDataMapper(LocalDateTime date, String endpoint, String request, String response) {
    super();
    this.date = date;
    this.endpoint = endpoint;
    this.request = request;
    this.response = response;
  }
}
