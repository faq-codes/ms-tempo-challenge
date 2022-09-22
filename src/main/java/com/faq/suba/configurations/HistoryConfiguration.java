package com.faq.suba.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.faq.suba.adapters.gateways.GetHistory;
import com.faq.suba.adapters.gateways.GetHistoryGateway;
import com.faq.suba.adapters.gateways.db.HistoryRepository;
import com.faq.suba.adapters.presenters.HistoryGetPresenter;
import com.faq.suba.adapters.presenters.Presenter;
import com.faq.suba.models.HistoryGetInputModel;
import com.faq.suba.models.HistoryGetOutputModel;
import com.faq.suba.usecases.HistoryGetUseCase;
import com.faq.suba.usecases.UseCase;

@Configuration
public class HistoryConfiguration {

  @Bean
  GetHistoryGateway getHistoryGetGateway(HistoryRepository historyRepository) {
    return new GetHistory(historyRepository);
  }

  @Bean
  Presenter<HistoryGetInputModel, HistoryGetOutputModel> getHistoryGetPresenter() {
    return new HistoryGetPresenter();
  }

  @Bean
  UseCase<HistoryGetInputModel, HistoryGetOutputModel> getHistoryGetUseCase(
      GetHistoryGateway getHistory,
      Presenter<HistoryGetInputModel, HistoryGetOutputModel> presenter) {
    return new HistoryGetUseCase(getHistory, presenter);
  }

}
