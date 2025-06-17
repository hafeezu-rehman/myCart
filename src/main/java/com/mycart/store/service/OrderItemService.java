package com.mycart.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.mycart.store.model.OrderItem;
import com.mycart.store.repository.OrderItemRepository;

@Service
public class OrderItemService {
    private OrderItemRepository orderItemRepository;
    @Autowired
    public OrderItemService(OrderItemRepository orderItemRepository){
        this.orderItemRepository=orderItemRepository;
    }
    public void createOrderItem(OrderItem orderItem){
        if(orderItem.getPrice()!=null && orderItem.getQuantity()!=null && orderItem.getOrder()!=null && orderItem.getProduct()!=null)
            orderItemRepository.save(orderItem);
        else
            throw new IllegalArgumentException("Unable to create order item");
    }
    public List<OrderItem> findOrderItems(Long ordId){
        if(ordId !=null)
            return orderItemRepository.findByOrder_ord_id(ordId);
        throw new IllegalArgumentException("Unable to find order items");
    }
    public void updateOrderItem(OrderItem updatedOrderItem){
  
        if (updatedOrderItem.getPrice()!=null && updatedOrderItem.getQuantity()!=null && updatedOrderItem.getOrder()!=null && updatedOrderItem.getProduct()!=null) {
                orderItemRepository.findById(updatedOrderItem.getOrdItemId())
                .map(orderItem->{
                    orderItem.setOrder(updatedOrderItem.getOrder());
                    orderItem.setPrice(updatedOrderItem.getPrice());
                    orderItem.setProduct(updatedOrderItem.getProduct());
                    orderItem.setQuantity(updatedOrderItem.getQuantity());
                    return orderItem;
                })
                .orElseThrow(()->new IllegalArgumentException("Unable to update order items"));
        }
        else
            throw new IllegalArgumentException("Unable to update order items");
    }
    public void deleteOrderItem(OrderItem orderItem){
        if (orderItemRepository.findById(orderItem.getOrdItemId()).get()!=null)
            orderItemRepository.deleteById(orderItem.getOrdItemId());
        else
            throw new IllegalArgumentException("Unable to delete order items");
    }
}
