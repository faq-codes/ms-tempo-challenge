package com.faq.suba.entities;

public class CreateSubaEntity implements CreateSuba {

  @Override
  public Suba create(double x, double y, double porcent) {
    return new SubaEntity(x, y, porcent);
  }

}
