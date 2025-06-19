package com.mycart.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mycart.store.model.Product;
import com.mycart.store.service.ProductService;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }
    @GetMapping("/view")
    public ResponseEntity<List<Product>> viewProducts(){
        try {
            List<Product> allProducts = productService.findProducts();
            return ResponseEntity.ok(allProducts);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product, @RequestParam("file") MultipartFile file){
        try {
            File dir=new File("src/main/resources/static/images");
            if(!dir.exists()){
                dir.mkdir();
            }
            String fileName=file.getOriginalFilename();
            int dotIndex=fileName.lastIndexOf(".");
            String fileExtension="";
            if(dotIndex>0){
                fileExtension=fileName.substring(dotIndex);
            }
            String encryptedFileName=UUID.randomUUID().toString()+fileExtension;
            Path filePath=Paths.get("src/main/resources/static/images", encryptedFileName);
            Files.write(filePath, file.getBytes());
            product.setImage_url(encryptedFileName);
            productService.createProduct(product);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        try {
            productService.updateProduct(product);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        try {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.unprocessableEntity().build();
        }
    }
}
