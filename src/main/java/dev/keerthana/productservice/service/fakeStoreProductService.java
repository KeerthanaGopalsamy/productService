package dev.keerthana.productservice.service;

import dev.keerthana.productservice.dto.categoryRequestDTO;
import dev.keerthana.productservice.dto.createProductResponseDTO;
import dev.keerthana.productservice.dto.fakeStoreResponseDTO;
import dev.keerthana.productservice.models.category;
import dev.keerthana.productservice.models.product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Service("FakeStoreProductService")
public class fakeStoreProductService implements ProductService{
    private RestTemplate restTemplate;
    public fakeStoreProductService(RestTemplate restTemplate)
    {
        this.restTemplate=restTemplate;
    }
    public product getProductById(int id)
    {
     product prdct = new product();
        //call fakestore api
        //https://fakestoreapi.com/products/id
      ResponseEntity<fakeStoreResponseDTO> fakeStoreRes=restTemplate.getForEntity("https://fakestoreapi.com/products/"+id, fakeStoreResponseDTO.class);
        //get the response
        fakeStoreResponseDTO response=fakeStoreRes.getBody();
        //convert the response to product object
        prdct = convertFakeStoreResponseToProduct(response);
        //return the product object
        return prdct;
    }
public List<product> getAllProducts()
{
    List<product> response = new ArrayList<>();
    fakeStoreResponseDTO[] fakeStoreRes=restTemplate.getForObject("https://fakestoreapi.com/products/",fakeStoreResponseDTO[].class );
  for(fakeStoreResponseDTO fakeStoreDto:fakeStoreRes)
  {
response.add(convertFakeStoreResponseToProduct(fakeStoreDto));
  }
    return response;
}
    private product convertFakeStoreResponseToProduct(fakeStoreResponseDTO response) {
        if(response==null)
        {
            throw new IllegalArgumentException("No product found");
        }
        product prdc=new product();
        prdc.setId(response.getId());
        prdc.setTitle(response.getTitle());
        prdc.setDescription(response.getDescription());
        category cateGory=new category();cateGory.setTitle(response.getTitle());
        prdc.setCateGory(cateGory);
        prdc.setImageURL(response.getImage());
        return prdc;
    }

    public product createProduct(String category,
                                 String description,
                                 String imageURL,
                                 String title) {
        fakeStoreResponseDTO fakeStoreResponseDTO = new fakeStoreResponseDTO();
        fakeStoreResponseDTO.setDescription(description);
        fakeStoreResponseDTO.setCategory(category);
        fakeStoreResponseDTO.setImage(imageURL);
        fakeStoreResponseDTO.setTitle(title);
        ResponseEntity<fakeStoreResponseDTO> fkStRes= restTemplate.
                postForEntity("https://fakestoreapi.com/products",fakeStoreResponseDTO,fakeStoreResponseDTO.class);
        return convertFakeStoreResponseToProduct(fkStRes.getBody());
    }
}
