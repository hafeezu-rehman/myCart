package com.mycart.store.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycart.store.model.Order;
import com.mycart.store.model.OrderItem;
import com.mycart.store.model.Product;
import com.mycart.store.model.User;
import com.mycart.store.service.OrderItemService;
import com.mycart.store.service.OrderService;
import com.mycart.store.service.ProductService;
import com.mycart.store.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final CartController cartController;
    private final UserService userService;
    private final ProductService productService;
    @Autowired
    public OrderController(OrderService orderService, OrderItemService orderItemService, CartController cartController,
            UserService userService, ProductService productService) {
        this.orderService = orderService;
        this.orderItemService = orderItemService;
        this.cartController = cartController;
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/add/{userId}")
    public ResponseEntity<?> createOrder(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response){
        try {
            Map<Long, Integer> cartMap=cartController.viewCart(request).getBody();
            if(cartMap==null || cartMap.isEmpty()){
                return ResponseEntity.badRequest().build();
            }
            User user=new User();
            user=userService.findUser(id);
            double totalAmount=0.0;
            for(Map.Entry<Long,Integer> cartProduct:cartMap.entrySet()){
                Product product=productService.findProduct(cartProduct.getKey());
                Integer quantity=cartProduct.getValue();
                totalAmount+=quantity*product.getPrice();
            }
            Order order=new Order();
            order.setUser(user);
            order.setTotal_amount(totalAmount);
            order.setStatus("Pending");
            orderService.createOrder(order);
            //Generated Order
            
            for (Map.Entry<Long,Integer> cartProduct : cartMap.entrySet()) {
                Product product=productService.findProduct(cartProduct.getKey());
                Integer quantity=cartProduct.getValue();
                double price=quantity*product.getPrice();
                OrderItem orderItem=new OrderItem();
                orderItem.setOrder(order);
                orderItem.setPrice(price);
                orderItem.setQuantity(quantity);
                orderItem.setProduct(product);
                orderItemService.createOrderItem(orderItem);
            }
            //Generated order Items
            cartController.clearCart(response);
            return ResponseEntity.ok("Order successfully generated");
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
