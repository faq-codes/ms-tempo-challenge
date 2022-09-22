package com.faq.suba.adapters.presenters;

import java.util.ArrayList;

import com.faq.suba.models.HistoryGetInputModel;
import com.faq.suba.models.HistoryGetOutputModel;

public class HistoryGetPresenter implements Presenter<HistoryGetInputModel, HistoryGetOutputModel> {

  @Override
  public HistoryGetOutputModel successResponse(String message, HistoryGetOutputModel outputModel) {
    return outputModel;
  }

  @Override
  public HistoryGetOutputModel errorResponse(String message, HistoryGetInputModel inputModel) {
    return new HistoryGetOutputModel(new ArrayList<>());
  }

}
