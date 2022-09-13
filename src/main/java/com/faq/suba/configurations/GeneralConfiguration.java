package com.faq.suba.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.faq.suba.adapters.gateways.GetPercent;
import com.faq.suba.adapters.gateways.GetPercentGateway;
import com.faq.suba.adapters.gateways.api.ExternalApiGateway;
import com.faq.suba.adapters.gateways.api.ExternalApiMock;
import com.faq.suba.adapters.presenters.Presenter;
import com.faq.suba.adapters.presenters.SubaPresenter;
import com.faq.suba.entities.CreateSuba;
import com.faq.suba.entities.CreateSubaEntity;
import com.faq.suba.models.SubaInputModel;
import com.faq.suba.models.SubaOutputModel;
import com.faq.suba.usecases.SubaUseCase;
import com.faq.suba.usecases.UseCase;

@Configuration
public class GeneralConfiguration {

  @Bean
  CreateSuba getCreateSuba() {
    return new CreateSubaEntity();
  }

  @Bean
  ExternalApiGateway getExternalApiGateway() {
    return new ExternalApiMock();
  }

  @Bean
  GetPercentGateway getPercentGateway(ExternalApiGateway externalApi) {
    return new GetPercent(externalApi);
  }

  @Bean
  Presenter<SubaInputModel, SubaOutputModel> getPresenter() {
    return new SubaPresenter();
  }

  @Bean
  UseCase<SubaInputModel, SubaOutputModel> getUseCase(
      CreateSuba createSuba,
      GetPercentGateway getPercent,
      Presenter<SubaInputModel, SubaOutputModel> presenter) {
    return new SubaUseCase(createSuba, getPercent, presenter);
  }

}
