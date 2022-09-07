package com.faq.suba.usecases;

import com.faq.suba.adapters.gateways.GetPercentGateway;
import com.faq.suba.adapters.presenters.Presenter;
import com.faq.suba.entities.CreateSuba;
import com.faq.suba.models.SubaInputModel;
import com.faq.suba.models.SubaOutputModel;

public class SubaUseCase implements UseCase<SubaInputModel, SubaOutputModel> {

  private CreateSuba createSuba;
  private GetPercentGateway getPercent;
  private Presenter<SubaInputModel, SubaOutputModel> presenter;

  public SubaUseCase(
      CreateSuba createSuba,
      GetPercentGateway getPercent,
      Presenter<SubaInputModel, SubaOutputModel> presenter) {
    this.createSuba = createSuba;
    this.getPercent = getPercent;
    this.presenter = presenter;
  }

  @Override
  public SubaOutputModel execute(SubaInputModel inputModel) {
    var percent = getPercent.getPercent();
    var suba = createSuba.create(inputModel.getX(), inputModel.getY(), percent);

    if (!suba.numberIsValid()) {
      return presenter.errorView("Los número ingresados no son válidos", inputModel);
    }

    if (!suba.porcentIsValid()) {
      return presenter.errorView("El porcentaje obtenido no es válido", inputModel);
    }

    suba.calculate();

    if (Double.isNaN(suba.getResult())) {
      return presenter.errorView("El resultado calculado no es válido", inputModel);
    }

    var outputModel = new SubaOutputModel(suba.getResult());

    return presenter.sucessView("Se ha calculado el valor satisfactoriamente", outputModel);
  }

}
