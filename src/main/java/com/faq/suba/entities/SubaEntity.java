package com.faq.suba.entities;

/**
 * SubaEntity implements the Suba interface
 * and is in charge of defining the business rules.
 * In this case, calculate an increase in the sum
 * of two values ​​according to a given percentage.
 */
public class SubaEntity implements Suba {

  private final double x;
  private final double y;
  private final double percent;

  private double result;

  // constructor
  public SubaEntity(double x, double y, double percent) {
    this.x = x;
    this.y = y;
    this.percent = percent;
    this.result = Double.NaN;
  }

  /**
   * If the x and y values are not NaN, then the numbers are valid.
   * 
   * @return The boolean value of the statement.
   */
  @Override
  public boolean isNumbersValid() {
    return !Double.isNaN(x) && !Double.isNaN(y);
  }

  /**
   * If the percent is not a number, then it's not valid.
   * 
   * @return The value of the percent variable.
   */
  @Override
  public boolean isPercentValid() {
    return !Double.isNaN(percent);
  }

  /**
   * If the result is not a number or infinite, then the result is valid.
   * 
   * @return The result of the calculation.
   */
  @Override
  public boolean isResultValid() {
    return !Double.isNaN(result) && !Double.isInfinite(result);
  }

  /**
   * The calculate function calculates the result of adding x and y, and add the
   * percent
   */
  @Override
  public void calculate() {
    result = (x + y) + ((x + y) * percent / 100.0);
  }

  /**
   * If the result is not null, return it. Otherwise, return the result of the
   * next calculator in the chain.
   * 
   * @return The result of the calculation.
   */
  @Override
  public Double getResult() {
    return result;
  }

}
