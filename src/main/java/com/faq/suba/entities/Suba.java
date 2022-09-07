package com.faq.suba.entities;

public interface Suba {
  boolean isNumbersValid();
  boolean isPercentValid();
  boolean isResultValid();

  void calculate();
  
  Double getResult();
}
