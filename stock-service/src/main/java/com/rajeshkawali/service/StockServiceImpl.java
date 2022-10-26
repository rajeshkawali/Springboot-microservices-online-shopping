package com.rajeshkawali.service;

import com.rajeshkawali.dto.StockResponse;
import com.rajeshkawali.model.Stock;
import com.rajeshkawali.repository.StockRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Rajesh_Kawali
 *
 */
@Service
@Slf4j
public class StockServiceImpl implements StockService {

    public static final String CLASS_NAME = StockServiceImpl.class.getName();

    @Autowired
    public StockRepository stockRepository;

    @Transactional(readOnly = true)
    public List<StockResponse> isInStock(List<String> skuCode) {
        String _function = ".isInStock";
        log.info(CLASS_NAME + _function + "::ENTER");
        List<StockResponse> stockList = new ArrayList<StockResponse>();
        stockList = stockRepository.findBySkuCodeIn(skuCode).stream().map(
                stock -> StockResponse.builder().skuCode(stock.getSkuCode())
                        .isInStock(stock.getQuantity() > 0).build()).toList();
        log.info(CLASS_NAME + _function + "::EXIT");
        return stockList;
    }

    @Override
    public String addStock(Stock stock) {
        String _function = ".addStock";
        log.info(CLASS_NAME + _function + "::ENTER");
        stockRepository.save(stock);
        log.info(CLASS_NAME + _function + "::EXIT");
        return "Successfully added";
    }
}
