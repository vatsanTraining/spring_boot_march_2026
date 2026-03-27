package com.example.demo.ifaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dtos.ResponseDto;
import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	   List<ResponseDto> findByCategory(String srch);
	
		@Query(value = "from Product where ratePerUnit<:srch",nativeQuery = false)
		List<Product> getPriceLessThan(@Param("srch") double amount);
		
		 @Query(value = "select * from product_mar_26 where rate_per_unit>:val ",nativeQuery = true)
		 List<Product> getPriceGrtThan(@Param("val") double srch);
		
		@Query(value = "Update Product set category =:newCategory where productId=:id",nativeQuery = false)
		@Modifying
		@Transactional
		int updateCategory(@Param("newCategory") String newStatus , @Param("id") int id);

	
}
