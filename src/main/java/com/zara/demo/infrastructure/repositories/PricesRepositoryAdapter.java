package com.zara.demo.infrastructure.repositories;

import com.zara.demo.domain.model.Prices;
import com.zara.demo.domain.ports.out.PricesRepositoryPort;
import com.zara.demo.infrastructure.entities.PricesEntity;
import com.zara.demo.infrastructure.mappers.PricesMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PricesRepositoryAdapter implements PricesRepositoryPort {

    private final PricesRepository pricesRepository;

    private final PricesMapper pricesMapper;

    @Override
    public List<Prices> retrievePrices(LocalDateTime applicationTime, Long brandId, Long productId) {
        List<PricesEntity> pricesEntities = pricesRepository.getPricesByApplicationDateBrandIdPriceId(applicationTime, brandId, productId);
        List<Prices> prices = new ArrayList<>();
        if(pricesEntities != null && !pricesEntities.isEmpty()){
            prices = pricesEntities.stream()
                    .map(pricesMapper::toDomain)
                    .toList();
        }
	return prices;
    }
}
