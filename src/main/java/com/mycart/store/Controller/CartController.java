package com.mycart.store.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/cart")
public class CartController {
    private final ObjectMapper objectMapper=new ObjectMapper();

    @PostMapping("/add/{id}")
    public ResponseEntity<String> addToCart(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response){
        List<Long> existingCart=getCartFromCookie(request);
        existingCart.add(id);
        addCartToCookie(response, existingCart);
        return ResponseEntity.ok("Product added to cart");
    }
    @GetMapping("/view")
    public ResponseEntity<Map<Long,Integer>> viewCart(HttpServletRequest request){
        List<Long> cart=getCartFromCookie(request);
        if(cart.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        Map<Long, Integer> productQuantity = new HashMap<>();
        List<Long> counted=new ArrayList<>();
        for(Long id:cart){
            if(!counted.contains(id)){
                int count=0;
                for(Long item:cart){
                    if (item.equals(id)) {
                        count++;
                    }
                }
                productQuantity.put(id, count);
                counted.add(id);
            }
        }
        return ResponseEntity.ok(productQuantity);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCartProduct(@PathVariable Long id, HttpServletRequest request, HttpServletResponse response){
        List<Long> cart=getCartFromCookie(request);
        if(!cart.contains(id)){
            return ResponseEntity.badRequest().body("Product not present");
        }
        cart.removeIf(item->item.equals(id));
        addCartToCookie(response, cart);
        return ResponseEntity.ok("Product removed from cart");
    }
    @DeleteMapping("/clear")
    public ResponseEntity<?> clearCart(HttpServletResponse response){
        Cookie cookie=new Cookie("cart", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return ResponseEntity.ok("Cart has been cleared.");
    }

    public List<Long> getCartFromCookie(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        List<Long> cart=new ArrayList<>();
        if (cookies!=null) {
            for(Cookie cookie:cookies){
                if ("cart".equals(cookie.getName())) {
                    try {
                        String decoded = URLDecoder.decode(cookie.getValue(), StandardCharsets.UTF_8);
                        cart = objectMapper.readValue(decoded, new TypeReference<>() {});
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return cart;
    }
    public void addCartToCookie(HttpServletResponse response, List<Long> cart){
        try {
                String json=objectMapper.writeValueAsString(cart);
                String encoded=URLEncoder.encode(json, StandardCharsets.UTF_8);
                Cookie cookie= new Cookie("cart",encoded);
                cookie.setPath("/");
                cookie.setHttpOnly(true);
                cookie.setMaxAge(7*24*60*60);
                response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        
        }
    }
}
