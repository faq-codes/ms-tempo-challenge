package com.faq.suba.entities;

public interface Suba {
  boolean numberIsValid();
  boolean porcentIsValid();

  void calculate();
  
  Double getResult();
}
