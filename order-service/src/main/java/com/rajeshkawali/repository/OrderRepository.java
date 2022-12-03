package com.rajeshkawali.repository;

import com.rajeshkawali.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * @author Rajesh_Kawali
 *
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
