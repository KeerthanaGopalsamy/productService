package dev.keerthana.productservice.controller;

import dev.keerthana.productservice.Exception.ProductNotFoundException;
import dev.keerthana.productservice.dto.createProductResponseDTO;
import dev.keerthana.productservice.models.product;
import dev.keerthana.productservice.service.ProductService;
import dev.keerthana.productservice.service.SelfProductService;
import dev.keerthana.productservice.service.fakeStoreProductService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productController {
    ProductService service;
    productController(@Qualifier("selfProductService")ProductService service)
    {
        this.service=service;
    }
    @PostMapping("/products")
    public product createProduct(@RequestBody createProductResponseDTO request)
    {
        if(request.getCategory()==null||request.getDescription()==null||request.getImage()==null||request.getTitle()==null)
        {
            throw new IllegalArgumentException("Invalid input");
        }
        product prod =service.createProduct(request.getCategory().getTitle(),request.getDescription(),request.getImage(),request.getTitle());
return prod;
    }
    @GetMapping("/products")
    public List<product> getAllProducts()
    {
        //validation
        //call service layer

//        throw new RuntimeException();
        return service.getAllProducts();
    }
    @GetMapping("/products/{id}")
    public product getProductById(@PathVariable("id")int id) throws ProductNotFoundException
    {
        //get single product by id
        if(id==10000)
        {
            throw new IllegalArgumentException("id cannot be 10000");
        }
        product prdct = service.getProductById(id);
        if(prdct==null)
        {
            throw new ProductNotFoundException("product not found");
        }
        return prdct;
    }
    @DeleteMapping("/products/{id}")
    public void deleteProductbyId(@PathVariable("id")int id)
    {

    }
    @PutMapping("/products/{id}")
    public void updateProduct(@PathVariable("id")int id)
    {

    }
    public void deleteProduct()
    {

    }

}
