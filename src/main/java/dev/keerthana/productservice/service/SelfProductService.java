package dev.keerthana.productservice.service;

import dev.keerthana.productservice.models.product;
import dev.keerthana.productservice.models.category;
import dev.keerthana.productservice.repository.CategoryRepository;
import dev.keerthana.productservice.repository.ProductRepository;
import dev.keerthana.productservice.repository.Projection.ProductProjection;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service("selfProductService")
public class SelfProductService implements ProductService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public product getProductById(int id) {
        product response = productRepository.findById(id).get();
        System.out.println("fetched response: " + response);
        return response;
    }
//getAllProducts
    @Override
    public List<product> getAllProducts() {
        ProductProjection response= productRepository.getProductByTitle("ipad");
        System.out.println(response.getTitle()+" "+response.getDescription());
        return productRepository.findAll();
    }

    @Override
    public product createProduct(String category, String description, String imageURL, String title) {
        //s1
        //validations
        validateInputRequest(category, description, imageURL, title);//use advice kind exception handling
//step2
        category category1 = new category();
        product prod = new product();
        prod.setTitle(title);
        prod.setDescription(description);
        prod.setCreatedAt(new Date());
        prod.setUpdatedAt(new Date());
        prod.setImageURL(imageURL);
        //step3 : check if category present in db
        category isCategoryExist = categoryRepository.findByTitle(category).get();
        if (isCategoryExist == null) {
            category1.setTitle(category);
        }
        prod.setCateGory(category1);
        //save to DB
        product response = productRepository.save(prod);
        return response;
    }

    private void validateInputRequest(String category, String description, String imageURL, String title) {
        if (category == null || description == null || imageURL == null || title == null) {
            throw new IllegalArgumentException("Invalid input");
        }
    }
}
