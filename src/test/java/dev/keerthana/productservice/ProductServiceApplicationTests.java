package dev.keerthana.productservice;

import dev.keerthana.productservice.models.product;
import dev.keerthana.productservice.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class ProductServiceApplicationTests {
	@Autowired
private ProductRepository prodrepo ;
//	@Test
	void contextLoads() {
	}
	@Test
	void testprodRepo()
	{
		Optional<product> p = prodrepo.findById(1);
		System.out.println("hi   "+p.get());
	}

}
