package com.rajeshkawali.repository;

import com.rajeshkawali.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    List<Stock> findBySkuCodeIn(List<String> skuCode);
}
