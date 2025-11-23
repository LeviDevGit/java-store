package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dtos.ProductDTO;
import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAllProducts() {
        List<Product> result = productRepository.findAll();
        return result.stream().map(ProductDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public Product getByProductId(Long id) {
        Product result = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return result;
    }

    @Transactional
    public Product createProduct(ProductDTO body) {
        Product product = productRepository.save(new Product(body));
        return product;
    }

    @Transactional
    public Product updateProduct(ProductDTO body, Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        if (body.getNome() != null) {
            product.setNome(body.getNome());
        }

        if (body.getDescricao() != null) {
            product.setDescricao(body.getDescricao());
        }

        if (body.getPreco() != null) {
            product.setPreco(body.getPreco());
        }

        if (body.getEstoque() != null) {
            product.setEstoque(body.getEstoque());
        }

        return product;
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        productRepository.delete(product);
    }
}
