package com.sda.springapporderclient.service;

import com.sda.springapporderclient.exception.ProductNotFoundException;
import com.sda.springapporderclient.model.Product;
import com.sda.springapporderclient.repository.OrderRepository;
import com.sda.springapporderclient.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, Product product) {
        Product toEdited = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        toEdited.setDescription(product.getDescription());
        toEdited.setName(product.getName());
        toEdited.setPrize(product.getPrize());
        return productRepository.save(toEdited);
    }

    public void deleteProduct(Long id) {
        Product toDelete = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
        productRepository.delete(toDelete);
    }
}
