package com.madhur.crud.example.service;

import com.madhur.crud.example.entity.Product;
import com.madhur.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    // 2 post methods
    //1)to save/post a single product
    public Product saveProduct(Product product){
        return repository.save(product);
    }

    //2)to save/post list of products
    public List<Product> saveProducts(List<Product> products){
        return repository.saveAll(products);
    }

    //3 get methods
    //1)to get a list of products by id
    public List<Product> getProducts(){
        return repository.findAll();
    }

    //2)to get a single product by id
    public Product getProductById(int id){
        return repository.findById(id).orElse(null);
    }

    //3)to get product by name
    public Product getProductByName(String Name){
        return repository.findByName(Name);
    }

    //Delete method
    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed !! " + id;
    }

    public Product updateProduct(Product product){
        Product existingProduct=repository.findById(product.getId()).orElse(null);
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        return repository.save(existingProduct);
    }

}
