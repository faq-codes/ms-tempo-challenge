package com.faq.suba.entities;

/**
 * A HISTORY factory method is created to isolate HISTORY creation 
 * and keep the Stable Abstractions Principle.
 * CreateHistoryEntity implements the CreateHistory interface
 */
public class CreateHistoryEntity implements CreateHistory {

  @Override
  public History create(String endpoint, String request, String response) {
    return new HistoryEntity(endpoint, request, response);
  }
  
}
