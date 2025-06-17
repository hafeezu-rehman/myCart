package com.mycart.store.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.mycart.store.model.Product;
import com.mycart.store.service.ProductService;
import java.util.*;;
@RestController
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/api/products")
    public ResponseEntity<List<Product>> viewProducts(){
        try {
            List<Product> allProducts = productService.findProducts();
            return ResponseEntity.ok(allProducts);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    @PostMapping("/api/add-product")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        try {
            productService.createProduct(product);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    @PutMapping("/api/update-product")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        try {
            productService.updateProduct(product);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    @DeleteMapping("/api/delete-product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
