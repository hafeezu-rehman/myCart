package com.mycart.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycart.store.model.Order;
import com.mycart.store.repository.OrderRepository;

@Service
public class OrderService {
    OrderRepository orderRepository;
    @Autowired
    public OrderService(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }
    public void createOrder(Order order){
        if(order.getStatus()!=null && order.getTotal_amount()!=null)
            orderRepository.save(order);
        else
            throw new IllegalArgumentException("Unable to create order");
    }
    public Order findOrder(Long ordId){
        return orderRepository.findById(ordId)
        .orElseThrow(()->new IllegalArgumentException("Unable to find order"));
    }
    public void updateOrder(Order updatedOrder){
        if(updatedOrder.getStatus()!=null && updatedOrder.getTotal_amount()!=null){
            orderRepository.findById(updatedOrder.getOrd_id())
            .map(order->{
                order.setStatus(updatedOrder.getStatus());
                order.setTotal_amount(updatedOrder.getTotal_amount());
                order.setUser(updatedOrder.getUser());
                return order;
            })
            .orElseThrow(()->new IllegalArgumentException("Unable to update order"));
        }
        else
            throw new IllegalArgumentException("Unable to update order");
    }
    public void deleteOrder(Order order){
        if(findOrder(order.getOrd_id())!=null)
            orderRepository.deleteById(order.getOrd_id());
        else
            throw new IllegalArgumentException("Unable to update order");

    }
}
