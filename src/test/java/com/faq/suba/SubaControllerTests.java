package com.faq.suba;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.boot.test.context.SpringBootTest;

import com.faq.suba.adapters.gateways.GetPercentGateway;
import com.faq.suba.adapters.presenters.Presenter;
import com.faq.suba.entities.CreateSuba;
import com.faq.suba.entities.SubaEntity;
import com.faq.suba.models.SubaInputModel;
import com.faq.suba.models.SubaOutputModel;
import com.faq.suba.usecases.SubaUseCase;
import com.faq.suba.usecases.UseCase;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class SubaControllerTests {
  
  @Mock
  CreateSuba createSuba;

  @Mock
  GetPercentGateway getPercent;

  @Mock
  Presenter<SubaInputModel, SubaOutputModel> presenter;

  @InjectMocks
  SubaUseCase useCase;

  @BeforeEach
  void init() {
    assertTrue(createSuba instanceof CreateSuba);
    assertTrue(getPercent instanceof GetPercentGateway);
    assertTrue(presenter instanceof Presenter);
    assertTrue(useCase instanceof UseCase);
  }

  @ParameterizedTest
  @MethodSource("getSubaSuccessData")
  void givenXY_whenCalculate_thenSuccessResult(double x, double y, double percent, double result) {
    // var suba = new SubaEntity(x, y, percent);
    // var inputModel = new SubaInputModel(x, y);
    // var outputModel = new SubaOutputModel(result);

    // when(presenter.successResponse(anyString(), any(SubaOutputModel.class))).thenReturn(outputModel);
    // when(getPercent.getPercent()).thenReturn(percent);
    // when(createSuba.create(x, y, percent)).thenReturn(suba);

    // var subaOutputModel = useCase.execute(inputModel);

    // assertNotNull(subaOutputModel);
    // assertEquals(result, subaOutputModel.getResult());

    // verify(presenter).successResponse(anyString(), any(SubaOutputModel.class));
  }

  private static final Object[] getSubaSuccessData() {
    return new Object[] {
        new Object[] { 5.0, 5.0, 10.0, 11.0 },
        new Object[] { 3.0, 7.0, 10.0, 11.0 },
        new Object[] { 3.0, 7.0, 10.0, 15.0 },
    };
  }
}
