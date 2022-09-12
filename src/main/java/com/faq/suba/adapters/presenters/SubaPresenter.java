package com.faq.suba.adapters.presenters;

import com.faq.suba.models.SubaInputModel;
import com.faq.suba.models.SubaOutputModel;

public class SubaPresenter implements Presenter<SubaInputModel, SubaOutputModel> {

  @Override
  public SubaOutputModel successResponse(String message, SubaOutputModel outputModel) {
    return outputModel;
  }

  @Override
  public SubaOutputModel errorResponse(String message, SubaInputModel inputModel) {
    return new SubaOutputModel(0.0);
  }

}
