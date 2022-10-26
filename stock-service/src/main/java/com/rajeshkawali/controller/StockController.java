package com.rajeshkawali.controller;

import com.rajeshkawali.dto.StockResponse;
import com.rajeshkawali.model.Stock;
import com.rajeshkawali.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Rajesh_Kawali
 *
 */
@RestController
@RequestMapping("/api/stock")
public class StockController {

    @Autowired StockService stockService;

    @GetMapping("/getStock")
    @ResponseStatus(HttpStatus.OK)
    public List<StockResponse> isInStock(@RequestParam List<String> skuCode) {
        return stockService.isInStock(skuCode);
    }

    @PostMapping("/addStock")
    @ResponseStatus(HttpStatus.CREATED)
    public String addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }
}

