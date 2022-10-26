package com.rajeshkawali.repository;


import com.rajeshkawali.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Rajesh_Kawali
 *
 */
@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
