package com.zara.demo.domain.ports.in;

import com.zara.demo.domain.model.dto.PricesDto;

import java.time.LocalDateTime;

public interface RetrievePricesUseCase {

    PricesDto retrievePrices(LocalDateTime applicationDate, Long brandId, Long productId);
}
