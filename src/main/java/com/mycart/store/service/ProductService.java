package com.mycart.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mycart.store.model.Product;
import com.mycart.store.repository.ProductRepository;

@Service
public class ProductService {
    ProductRepository productRepository;
    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    public void createProduct(Product product){
        if (product.getName()!=null && product.getPrice()!=null && product.getCategory()!=null && product.getStock()!=null && product.getDescription()!=null && product.getImage_url()!=null) 
            productRepository.save(product);
        else
            throw new IllegalArgumentException("Unable to create product");
    }
    public List<Product> findProducts(){
        return productRepository.findAll();
    }
    public Product findProduct(Long id){
        return productRepository.findById(id)
        .orElseThrow(()->new IllegalArgumentException("Product not found"));
    }
    public void updateProduct(Product updatedProduct){
        if(updatedProduct.getName()!=null && updatedProduct.getPrice()!=null && updatedProduct.getCategory()!=null && updatedProduct.getStock()!=null && updatedProduct.getDescription()!=null && updatedProduct.getImage_url()!=null){
            productRepository.findById(updatedProduct.getProd_id())
            .map(product->{
                product.setName(updatedProduct.getName());
                product.setCategory(updatedProduct.getCategory());
                product.setDescription(updatedProduct.getDescription());
                product.setImage_url(updatedProduct.getImage_url());
                product.setPrice(updatedProduct.getPrice());
                product.setStock(updatedProduct.getStock());
                return productRepository.save(product);
            })
            .orElseThrow(()->new IllegalArgumentException("Unable to update product"));
        }
        else
            throw new IllegalArgumentException("Unable to update product");
    }
    public void deleteProduct(Long id){
        if (productRepository.findById(id).get()!=null)
            productRepository.deleteById(id);
        else
            throw new IllegalArgumentException("Unable to delete product");
    }
}
