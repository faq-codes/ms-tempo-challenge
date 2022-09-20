package com.faq.suba.adapters.controllers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.faq.suba.models.HistoryInputModel;
import com.faq.suba.models.HistoryOutputModel;
import com.faq.suba.usecases.UseCase;

@Component
@Order(-999)
@WebFilter(urlPatterns = "/*")
public class FilterController extends OncePerRequestFilter {

  UseCase<HistoryInputModel, HistoryOutputModel> historyUseCase;

  // private static final Logger logger = LogManager.getLogger();

  public FilterController(UseCase<HistoryInputModel, HistoryOutputModel> historyUseCase) {
    this.historyUseCase = historyUseCase;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {

    var req = new ContentCachingRequestWrapper(request);
    var resp = new ContentCachingResponseWrapper(response);

    // Execution request chain
    filterChain.doFilter(req, resp);

    var endpoint = req.getRequestURI();
    var params = req.getQueryString();
    var requestBody = new String(req.getContentAsByteArray(), StandardCharsets.UTF_8);
    var responseBody = new String(resp.getContentAsByteArray(), StandardCharsets.UTF_8);

    new Thread(() -> {

      var inputModel = new HistoryInputModel(endpoint, requestBody, responseBody);

      var outpulModel = historyUseCase.execute(inputModel);

    }).start();

    resp.copyBodyToResponse();
  }
}
