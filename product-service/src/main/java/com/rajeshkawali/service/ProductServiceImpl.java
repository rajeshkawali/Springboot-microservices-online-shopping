package com.rajeshkawali.service;


import com.rajeshkawali.dto.ProductRequest;
import com.rajeshkawali.dto.ProductResponse;
import com.rajeshkawali.model.Product;
import com.rajeshkawali.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * @author Rajesh_Kawali
 *
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    public static final String CLASS_NAME = ProductServiceImpl.class.getName();

    @Autowired private ProductRepository productRepository;

    public void saveProduct(ProductRequest productRequest) {
        String _function = ".saveProduct()";
        log.info(CLASS_NAME + _function + "::ENTER");
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .productNumber(productRequest.getProductNumber())
                .build();
        productRepository.save(product);
        log.debug(CLASS_NAME + _function + "::Product with id {} is saved successfully", product.getId());
        log.info(CLASS_NAME + _function + "::EXIT");
    }

    public List<ProductResponse> getAllProducts() {
        String _function = ".getAllProducts()";
        log.info(CLASS_NAME + _function + "::ENTER");
        List<Product> products = productRepository.findAll();
        log.info(CLASS_NAME + _function + "::EXIT");
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .productNumber(product.getProductNumber())
                .price(product.getPrice())
                .build();
    }
}
