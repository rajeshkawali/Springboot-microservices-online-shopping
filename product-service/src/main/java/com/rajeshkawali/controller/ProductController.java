package com.rajeshkawali.controller;

import com.rajeshkawali.dto.ProductRequest;
import com.rajeshkawali.dto.ProductResponse;
import com.rajeshkawali.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @author Rajesh_Kawali
 *
 */
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired private ProductService productService;

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody ProductRequest productRequest) {
        productService.saveProduct(productRequest);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

}
