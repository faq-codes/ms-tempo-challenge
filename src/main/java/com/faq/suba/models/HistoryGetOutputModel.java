package com.faq.suba.models;

import java.util.List;

public class HistoryGetOutputModel {
  private final List<HistoryDataModel> result;

  public List<HistoryDataModel> getResult() {
    return result;
  }

  public HistoryGetOutputModel(List<HistoryDataModel> result) {
    this.result = result;
  }

}
