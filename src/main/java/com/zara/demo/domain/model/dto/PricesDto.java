package com.zara.demo.domain.model.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PricesDto(Long productId, Long brandId, String nameBrand, BigDecimal price, LocalDateTime startDate,
	LocalDateTime endDate) implements Serializable {

}
