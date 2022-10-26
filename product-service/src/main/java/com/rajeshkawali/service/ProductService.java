package com.rajeshkawali.service;

import com.rajeshkawali.dto.ProductRequest;
import com.rajeshkawali.dto.ProductResponse;

import java.util.List;
/**
 * @author Rajesh_Kawali
 *
 */
public interface ProductService {

    public void saveProduct(ProductRequest productRequest) ;

    public List<ProductResponse> getAllProducts();
}