package com.faq.suba.entities;

public class SubaEntity implements Suba {

  double x;
  double y;
  double porcent;
  double result;

  public SubaEntity(double x, double y, double porcent) {
    this.x = x;
    this.y = y;
    this.porcent = porcent;
  }

  @Override
  public boolean numberIsValid() {
    return !Double.isNaN(x) && !Double.isNaN(y);
  }

  @Override
  public boolean porcentIsValid() {
    return !Double.isNaN(porcent);
  }

  @Override
  public void calculate() {
    result = (x + y) + ((x + y) * porcent / 100.0);
  }

  @Override
  public Double getResult() {
    return result;
  }
}
