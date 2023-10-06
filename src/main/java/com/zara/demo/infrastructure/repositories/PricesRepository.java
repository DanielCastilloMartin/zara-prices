package com.zara.demo.infrastructure.repositories;

import com.zara.demo.infrastructure.entities.PricesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<PricesEntity, Long> {

    @Query("SELECT p from PricesEntity p where p.startDate <= :applicationDate "
	    + "and p.endDate >= :applicationDate and p.brand.id= :brandId and p.product.id= :productId")
    List<PricesEntity> getPricesByApplicationDateBrandIdPriceId(
	    @Param("applicationDate") LocalDateTime applicationDate,
	    @Param("brandId") Long brandId,
	    @Param("productId") Long productId
    );
}
