package com.faq.suba.usecases;

public abstract class UseCaseAbstract {
  abstract <U, T> U execute(T inputModel);
}
