package com.faq.suba.adapters.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faq.suba.models.HistoryGetInputModel;
import com.faq.suba.models.HistoryGetOutputModel;
import com.faq.suba.usecases.UseCase;

@RestController
@RequestMapping("/api")
public class HistoryController {

  private static final Logger logger = LogManager.getLogger();

  UseCase<HistoryGetInputModel, HistoryGetOutputModel> historyGetUseCase;

  public HistoryController(UseCase<HistoryGetInputModel, HistoryGetOutputModel> historyGetUseCase) {
    this.historyGetUseCase = historyGetUseCase;
  }

  @GetMapping("/get")
  public HistoryGetOutputModel get(@RequestParam int pageIndex, @RequestParam int pageSize) {
    var historyGetInputModel = new HistoryGetInputModel(pageIndex, pageSize);
    logger.info(historyGetInputModel);
    return historyGetUseCase.execute(historyGetInputModel);
  }

}
