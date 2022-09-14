package com.faq.suba.usecases;

import com.faq.suba.adapters.gateways.SaveHistoryGateway;
import com.faq.suba.adapters.presenters.Presenter;
import com.faq.suba.entities.CreateHistory;
import com.faq.suba.models.HistoryDataModel;
import com.faq.suba.models.HistoryInputModel;
import com.faq.suba.models.HistoryOutputModel;

public class HistoryUseCase implements UseCase<HistoryInputModel, HistoryOutputModel> {

  private final CreateHistory createHistory;
  private final SaveHistoryGateway saveHistory;
  private Presenter<HistoryInputModel, HistoryOutputModel> presenter;

  public HistoryUseCase(
      CreateHistory createHistory,
      SaveHistoryGateway saveHistory,
      Presenter<HistoryInputModel, HistoryOutputModel> presenter) {
    this.createHistory = createHistory;
    this.saveHistory = saveHistory;
    this.presenter = presenter;
  }

  @Override
  public HistoryOutputModel execute(HistoryInputModel inputModel) {
    final var history = createHistory.create(inputModel.getEndpoint(), inputModel.getRequest(),
        inputModel.getResponse());

    final var historyData = new HistoryDataModel(history.getDate(), history.getEndpoint(), history.getRequest(),
        history.getResponse());

    final var result = saveHistory.save(historyData);

    if (result) {
      final var outputModel = new HistoryOutputModel(result);

      return presenter.successResponse("Se ha guardado el valor satisfactoriamente", outputModel);
    }

    return presenter.errorResponse("El valor no se ha guardado", inputModel);
  }

}
