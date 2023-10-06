package com.zara.demo.domain.ports.out;

import com.zara.demo.domain.model.Prices;
import com.zara.demo.domain.model.dto.PricesDto;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepositoryPort {

    List<Prices> retrievePrices(LocalDateTime applicationTime, Long brandId, Long productId);


}
