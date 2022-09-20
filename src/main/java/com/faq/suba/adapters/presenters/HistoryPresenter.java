package com.faq.suba.adapters.presenters;

import com.faq.suba.models.HistoryInputModel;
import com.faq.suba.models.HistoryOutputModel;

public class HistoryPresenter implements Presenter<HistoryInputModel, HistoryOutputModel> {

  @Override
  public HistoryOutputModel successResponse(String message, HistoryOutputModel outputModel) {
    return outputModel;
  }

  @Override
  public HistoryOutputModel errorResponse(String message, HistoryInputModel inputModel) {
    return new HistoryOutputModel(false);
  }

}
