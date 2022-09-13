package com.faq.suba.entities;

import java.time.LocalDateTime;

public interface History {
  int getId();

  LocalDateTime getDate();

  String getEndpoint();

  String getRequest();

  String getResponse();
}
