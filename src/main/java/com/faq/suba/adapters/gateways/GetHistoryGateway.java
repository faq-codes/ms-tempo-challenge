package com.faq.suba.adapters.gateways;

import java.util.List;

import com.faq.suba.models.HistoryDataModel;
import com.faq.suba.models.HistoryGetInputModel;

public interface GetHistoryGateway {
  List<HistoryDataModel> get(HistoryGetInputModel input);
}
