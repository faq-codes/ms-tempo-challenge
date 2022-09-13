package com.faq.suba.entities;

public interface CreateHistory {
  History create(String endpoint, String request, String response);
}
