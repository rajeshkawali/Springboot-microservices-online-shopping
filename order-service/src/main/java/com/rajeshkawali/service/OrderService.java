package com.rajeshkawali.service;


import com.rajeshkawali.dto.OrderRequest;
/**
 * @author Rajesh_Kawali
 *
 */
public interface OrderService {

    public String placeOrder(OrderRequest orderRequest);

}
