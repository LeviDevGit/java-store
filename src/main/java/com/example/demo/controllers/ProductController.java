package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    public ProductService productService;

    @GetMapping
    public List<ProductDTO> findAllProducts() {
        return productService.findAllProducts();
    }

    @GetMapping(value = "/{id}")
    public ProductDTO findProductById(@PathVariable Long id) {
        Product product = productService.getByProductId(id);
        return new ProductDTO(product);
    }

    @PostMapping
    public ProductDTO createProduct(@Valid @RequestBody ProductDTO body) {
        Product product = productService.createProduct(body);
        return new ProductDTO(product);
    }

    @PatchMapping(value = "/{id}")
    public ProductDTO updateProduct(@RequestBody ProductDTO body, @PathVariable Long id) {
        Product product = productService.updateProduct(body, id);
        return new ProductDTO(product);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
