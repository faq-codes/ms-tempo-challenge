package com.faq.suba;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
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

  @Test
  void givenXYPercent_whenCalculate_thenResult() {
    double x = 5.0;
    double y = 5.0;
    double percent = 10.0;
    double result = 11.0;

    var suba = new SubaEntity(x, y, percent);

    suba.calculate();

    assertThat(suba.getResult()).isEqualTo(result);
  }

}
