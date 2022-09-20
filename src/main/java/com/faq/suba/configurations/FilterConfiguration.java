package com.faq.suba.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.faq.suba.adapters.gateways.SaveHistoryGateway;
import com.faq.suba.adapters.presenters.HistoryPresenter;
import com.faq.suba.adapters.presenters.Presenter;
import com.faq.suba.entities.CreateHistory;
import com.faq.suba.entities.CreateHistoryEntity;
import com.faq.suba.models.HistoryInputModel;
import com.faq.suba.models.HistoryOutputModel;
import com.faq.suba.usecases.HistoryUseCase;
import com.faq.suba.usecases.UseCase;

@Configuration
public class FilterConfiguration {

  @Bean
  CreateHistory getCreateHistory() {
    return new CreateHistoryEntity();
  }

  @Bean
  Presenter<HistoryInputModel, HistoryOutputModel> getHistoryPresenter() {
    return new HistoryPresenter();
  }

  @Bean
  UseCase<HistoryInputModel, HistoryOutputModel> getHistoryUseCase(
      CreateHistory createHistory,
      SaveHistoryGateway saveHistory,
      Presenter<HistoryInputModel, HistoryOutputModel> presenter) {
    return new HistoryUseCase(createHistory, saveHistory, presenter);
  }
}