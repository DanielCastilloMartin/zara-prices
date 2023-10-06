package com.zara.demo.domain.ports.out;

import com.zara.demo.domain.model.dto.PricesDto;

import java.time.LocalDateTime;

public interface ExternalServicePort {

    PricesDto retrievePrices(LocalDateTime localDateTime, Long brandId, Long productId);
}
