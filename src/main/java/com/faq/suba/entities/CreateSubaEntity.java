package com.faq.suba.entities;

/**
 * A SUBA factory method is created to isolate SUBA creation 
 * and keep the Stable Abstractions Principle.
 * CreateSubaEntity implements the CreateSuba interface
 */
public class CreateSubaEntity implements CreateSuba {

  @Override
  public Suba create(double x, double y, double percent) {
    return new SubaEntity(x, y, percent);
  }

}
