package com.rajeshkawali.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * @author Rajesh_Kawali
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockResponse {
    private String skuCode;
    private boolean isInStock;
}