package com.faq.suba;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.faq.suba.entities.SubaEntity;

@SpringBootTest
class SubaApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void givenNaNNumber_whenPorcentIsNotValid_thenFalse() {
		double x = 5.0;
		double y = 5.0;
		double porcent = Double.NaN;

		var suba = new SubaEntity(x, y, porcent);

		assertThat(suba.porcentIsValid()).isFalse();
	}

	@Test
	void givenX_NaN_Number_whenNumberIsNotValid_thenFalse() {
		double x = Double.NaN;
		double y = 5.0;
		double porcent = 10;

		var suba = new SubaEntity(x, y, porcent);

		assertThat(suba.numberIsValid()).isFalse();
	}

	@Test
	void givenY_NaN_Number_whenNumberIsNotValid_thenFalse() {
		double x = 5.0;
		double y = Double.NaN;
		double porcent = 10;

		var suba = new SubaEntity(x, y, porcent);

		assertThat(suba.numberIsValid()).isFalse();
	}

	@Test
	void whenCalculateANDgetResult_thenNumberResult() {
		double x = 5.0;
		double y = 5.0;
		double porcent = 10.0;
		double result = 11.0;

		var suba = new SubaEntity(x, y, porcent);

		suba.calculate();

		assertThat(suba.getResult()).isNotNaN().isEqualTo(result);
	}

}
