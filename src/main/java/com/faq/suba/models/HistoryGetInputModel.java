package com.faq.suba.models;

public class HistoryGetInputModel {

  private final int pageIndex;
  private final int pageSize;

  public HistoryGetInputModel(int pageIndex, int pageSize) {
    this.pageIndex = pageIndex;
    this.pageSize = pageSize;
  }

  public int getPageIndex() {
    return pageIndex;
  }

  public int getPageSize() {
    return pageSize;
  }

}
