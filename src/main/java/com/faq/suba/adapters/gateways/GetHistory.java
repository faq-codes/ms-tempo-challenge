package com.faq.suba.adapters.gateways;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.PageRequest;

import com.faq.suba.adapters.gateways.db.HistoryRepository;
import com.faq.suba.models.HistoryDataModel;
import com.faq.suba.models.HistoryGetInputModel;

public class GetHistory implements GetHistoryGateway {

  private static final Logger logger = LogManager.getLogger();

  private final HistoryRepository repository;

  public GetHistory(HistoryRepository repository) {
    super();
    this.repository = repository;
  }

  @Override
  public List<HistoryDataModel> get(HistoryGetInputModel input) {
    var entity = repository.findAll(PageRequest.of(input.getPageIndex(), input.getPageSize()));

    // return (List<HistoryDataModel>) (HistoryDataMapper) entity.getContent();
    return entity
        .getContent()
        .stream()
        .map(data -> new HistoryDataModel(data.getDate(), data.getEndpoint(), data.getRequest(), data.getResponse()))
        .collect(Collectors.toList());
  }
}
