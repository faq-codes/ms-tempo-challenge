package com.faq.suba.usecases;

import com.faq.suba.adapters.gateways.GetHistoryGateway;
import com.faq.suba.adapters.presenters.Presenter;
import com.faq.suba.entities.CreateHistory;
import com.faq.suba.models.HistoryGetInputModel;
import com.faq.suba.models.HistoryGetOutputModel;

public class HistoryGetUseCase implements UseCase<HistoryGetInputModel, HistoryGetOutputModel> {

  private final CreateHistory createHistory;
  private final GetHistoryGateway getHistory;
  private Presenter<HistoryGetInputModel, HistoryGetOutputModel> presenter;

  public HistoryGetUseCase(
      CreateHistory createHistory,
      GetHistoryGateway getHistory,
      Presenter<HistoryGetInputModel, HistoryGetOutputModel> presenter) {
    this.createHistory = createHistory;
    this.getHistory = getHistory;
    this.presenter = presenter;
  }

  @Override
  public HistoryGetOutputModel execute(HistoryGetInputModel inputModel) {

    final var result = getHistory.get(inputModel);

    if (!result.isEmpty()) {
      final var outputModel = new HistoryGetOutputModel(result);

      return presenter.successResponse("Se han obtenido los datos satisfactoriamente", outputModel);
    }

    return presenter.errorResponse("Error al obtener los datos", inputModel);
  }

}
