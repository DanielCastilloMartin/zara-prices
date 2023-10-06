package com.zara.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Prices {

    private Product product;
    private Brand brand;
    private PriceList priceList;
    private LocalDateTime endDate;
    private LocalDateTime startDate;
    private BigDecimal price;
    private Integer priority;
    private String currency;
}
