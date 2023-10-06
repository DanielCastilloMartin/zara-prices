package com.zara.demo.application.usecases;

import com.zara.demo.domain.model.Prices;
import com.zara.demo.domain.model.constants.PricesConstant;
import com.zara.demo.domain.model.dto.PricesDto;
import com.zara.demo.domain.ports.in.RetrievePricesUseCase;
import com.zara.demo.domain.ports.out.PricesRepositoryPort;
import com.zara.demo.infrastructure.exception.PricesNotFoundException;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class RetrievePricesUseCaseImpl implements RetrievePricesUseCase {

    private final PricesRepositoryPort pricesRepositoryPort;

    @Override
    public PricesDto retrievePrices(LocalDateTime applicationDate, Long brandId, Long productId) {
	List<Prices> pricesList = pricesRepositoryPort.retrievePrices(applicationDate, brandId, productId);

	if (pricesList.isEmpty()) {
	    throw new PricesNotFoundException(PricesConstant.NOT_FOUND);
	}

	Prices prices = pricesList.stream().max(Comparator.comparing(Prices::getPriority)).stream().findFirst().get();
	return new PricesDto(prices.getProduct().getId(), prices.getBrand().getId(),
		prices.getBrand().getName(), prices.getPrice(), prices.getStartDate(), prices.getEndDate());
    }
}
