package com.faq.suba;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.faq.suba.entities.SubaEntity;

@SpringBootTest
public class SubaEntityTests {

  @Test
  void givenNaNNumber_whenPercentIsNotValid_thenFalse() {
    double x = 5.0;
    double y = 5.0;
    double percent = Double.NaN;

    var suba = new SubaEntity(x, y, percent);

    assertThat(suba.isPercentValid()).isFalse();
  }

  @Test
  void givenX_NaN_Number_whenNumberIsNotValid_thenFalse() {
    double x = Double.NaN;
    double y = 5.0;
    double percent = 10;

    var suba = new SubaEntity(x, y, percent);

    assertThat(suba.isNumbersValid()).isFalse();
  }

  @Test
  void givenY_NaN_Number_whenNumberIsNotValid_thenFalse() {
    double x = 5.0;
    double y = Double.NaN;
    double percent = 10;

    var suba = new SubaEntity(x, y, percent);

    assertThat(suba.isNumbersValid()).isFalse();
  }

  @Test
  void whenResultIsNotValid_thenFalse() {
    double x = 5.0;
    double y = 5.0;
    double percent = 1 / 0.0;

    var suba = new SubaEntity(x, y, percent);

    suba.calculate();

    assertThat(suba.isResultValid()).isFalse();
  }

  @ParameterizedTest
  @MethodSource("getSubaData")
  @DisplayName("")
  void givenXYPercent_whenCalculate_thenResult(double x, double y, double percent, double result) {
    var suba = new SubaEntity(x, y, percent);

    suba.calculate();

    assertEquals(result, suba.getResult());
  }

  private static final Object[] getSubaData() {
    return new Object[] {
        new Object[] { 5.0, 5.0, 10.0, 11.0 },
        new Object[] { 3.0, 7.0, 10.0, 11.0 }
    };
  }
}
