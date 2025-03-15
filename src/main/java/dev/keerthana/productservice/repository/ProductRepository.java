package dev.keerthana.productservice.repository;

import dev.keerthana.productservice.models.product;
import dev.keerthana.productservice.repository.Projection.ProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<product,Integer> {
    //select * from product where id = ?
Optional<product> findById(int id);

//selecty * from product where title = ?
Optional<product> findByTitle(String title);

//select * from product where category = ?
//    Optional<product> findByCategory(String category);
//
//    Optional<product> findByIdAndCategory(int id, String category);
//
//    Optional <List<product>> findAllByCategory(String category);
//
//    void deleteById(int id);
//    void deleteAllByCategory(String category);//should be in category
//HQL Query
//get product name by title
    @Query("select p.title,p.description from product p where p.title=:title")
    ProductProjection getProductByTitle(@Param("title")String title);

    @Query("select p.title from product p where p.id=:id")
    product getProductByTileAndByProductId(@Param("title")String title,@Param("id")int id);
}
