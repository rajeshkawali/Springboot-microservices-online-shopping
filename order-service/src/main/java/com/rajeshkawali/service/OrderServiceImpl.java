package com.rajeshkawali.service;

import com.rajeshkawali.dto.OrderLineItemsDto;
import com.rajeshkawali.dto.OrderRequest;
import com.rajeshkawali.dto.StockResponse;
import com.rajeshkawali.model.event.OrderPlacedEvent;
import com.rajeshkawali.model.Order;
import com.rajeshkawali.model.OrderLineItems;
import com.rajeshkawali.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
/**
 * @author Rajesh_Kawali
 *
 */
@Slf4j
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    public static final String CLASS_NAME = OrderServiceImpl.class.getName();
    @Autowired private OrderRepository orderRepository;
    @Autowired private  WebClient.Builder webClientBuilder;
    @Autowired
    private KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate;

    @Override
    public String placeOrder(OrderRequest orderRequest) {
        String _function = ".placeOrder";
        log.info(CLASS_NAME + _function + "::ENTER");
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemsList().stream()
                .map(OrderLineItems::getSkuCode)
                .toList();

        StockResponse[] stockResponseArray = webClientBuilder.build().get()
                .uri("http://STOCK-SERVICE/api/stock/getStock",
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(StockResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(stockResponseArray)
                .allMatch(StockResponse::isInStock);

        if (allProductsInStock) {
            order = orderRepository.save(order);
            log.info(CLASS_NAME + _function + "::Order Placed Successfully: {}",order.toString());
            try {
                kafkaTemplate.send("notifyTopic", new OrderPlacedEvent(order.getOrderNumber()));
            }catch(Exception e){
                log.error(CLASS_NAME + _function + "::Exception: "+e);
            }
            log.info(CLASS_NAME + _function + "::Order placed notification sent Successfully");
            log.info(CLASS_NAME + _function + "::EXIT");
            return "Order Placed Successfully";
        } else {
            log.error(CLASS_NAME + _function + "::Product not in stock, please try again later");
            throw new IllegalArgumentException("Product not in stock, please try again later");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }

}
