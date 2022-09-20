package com.faq.suba.adapters.gateways;

import org.springframework.stereotype.Component;

import com.faq.suba.adapters.gateways.db.HistoryDataMapper;
import com.faq.suba.adapters.gateways.db.HistoryRepository;
import com.faq.suba.models.HistoryDataModel;

@Component
public class SaveHistory implements SaveHistoryGateway {

  private final HistoryRepository repository;

  public SaveHistory(HistoryRepository repository) {
    super();
    this.repository = repository;
  }

  @Override
  public boolean save(HistoryDataModel model) {
    var data = new HistoryDataMapper(model.getDate(), model.getEndpoint(), model.getRequest(), model.getResponse());

    var entity = repository.save(data);

    return entity != null;
  }

}
