package com.faq.suba.adapters.presenters;

public interface Presenter<T, U> {
  U successResponse(String message, U outputModel);
  U errorResponse(String message, T inputModel);
}
