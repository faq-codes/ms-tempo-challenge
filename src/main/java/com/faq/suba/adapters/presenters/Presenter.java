package com.faq.suba.adapters.presenters;

public interface Presenter<T, U> {
  U successView(String message, U outputModel);
  U errorView(String message, T inputModel);
}
