package com.faq.suba.usecases;

public interface UseCase<T, U> {
  U execute(T inputModel);
}
