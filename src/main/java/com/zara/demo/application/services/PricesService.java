package com.zara.demo.application.services;

import com.zara.demo.domain.model.dto.PricesDto;
import com.zara.demo.domain.ports.in.RetrievePricesUseCase;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
public class PricesService implements RetrievePricesUseCase {

    private final RetrievePricesUseCase retrievePricesUseCase;


    @Override
    public PricesDto retrievePrices(LocalDateTime applicationDate, Long brandId, Long productId) {
	return retrievePricesUseCase.retrievePrices(applicationDate, brandId, productId);

    }

}
