package com.rajeshkawali.service;

import com.rajeshkawali.dto.StockResponse;
import com.rajeshkawali.model.Stock;

import java.util.List;

public interface StockService {

    public List<StockResponse> isInStock(List<String> skuCode);

    public String addStock(Stock stock);
}
