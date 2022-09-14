package com.faq.suba.adapters.gateways;

import com.faq.suba.models.HistoryDataModel;

public interface SaveHistoryGateway {
  boolean save(HistoryDataModel data);
}
