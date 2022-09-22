package com.faq.suba.adapters.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faq.suba.models.SubaInputModel;
import com.faq.suba.models.SubaOutputModel;
import com.faq.suba.usecases.UseCase;

@RestController
@RequestMapping("/api")
public class SubaController {

  private static final Logger logger = LogManager.getLogger();

  UseCase<SubaInputModel, SubaOutputModel> subaUseCase;

  public SubaController(UseCase<SubaInputModel, SubaOutputModel> subaUseCase) {
    this.subaUseCase = subaUseCase;
  }

  @PostMapping("/suba")
  public SubaOutputModel getSuba(@RequestBody SubaInputModel inputModel) {
    return subaUseCase.execute(inputModel);
  }

}
