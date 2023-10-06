package com.zara.demo.application.usecases;

import com.zara.demo.domain.model.Brand;
import com.zara.demo.domain.model.PriceList;
import com.zara.demo.domain.model.Prices;
import com.zara.demo.domain.model.Product;
import com.zara.demo.domain.ports.out.PricesRepositoryPort;
import com.zara.demo.infrastructure.exception.PricesNotFoundException;
import lombok.SneakyThrows;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

class RetrievePricesUseCaseImplTest {

    @Mock
    PricesRepositoryPort pricesRepositoryPort;

    @InjectMocks
    RetrievePricesUseCaseImpl retrievePricesUseCase;

    @BeforeEach
    void before(){
        MockitoAnnotations.openMocks(this);

    }

    @Test
    @SneakyThrows
    void should_work_when_call_retrieve_prices() {

        var retrieveList = retrievePriceList();
        when(pricesRepositoryPort.retrievePrices(any(), anyLong(), anyLong())).thenReturn(retrieveList);

        var priceDto = retrievePricesUseCase.retrievePrices(any(), anyLong(), anyLong());
        var localEndDate =LocalDateTime.of(2020, 6, 14, 18, 30,  0);
        assertAll(
                () -> verify(pricesRepositoryPort, times(1)).retrievePrices(any(), anyLong(), anyLong()),
                () -> assertNotNull(priceDto),
                () -> assertEquals(BigDecimal.valueOf(25.45), priceDto.price()),
                () -> assertEquals(priceDto.endDate(), localEndDate)
        );


    }

    @Test
    void should_not_work_and_throw_price_not_found_exception(){
        when(pricesRepositoryPort.retrievePrices(any(), anyLong(), anyLong())).thenReturn(List.of());

        Executable execution = () -> retrievePricesUseCase.retrievePrices(any(), anyLong(), anyLong());
        assertThrows(PricesNotFoundException.class, execution);
    }

    private List<Prices> retrievePriceList(){
        var localStartDate = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
        var localEndDate = LocalDateTime.of(2020, 12, 31, 23, 59,  59);

        Prices prices1 = Prices.builder().price(BigDecimal.valueOf(30.0))
                .endDate(localEndDate)
                .startDate(localStartDate)
                .brand(new Brand(1L, "zara", ""))
                .product(new Product(35455L, "Camiseta", ""))
                .priceList(new PriceList(1L, "Rebajas Invierno", ""))
                .priority(0)
                .price(BigDecimal.valueOf(35.50))
                .build();

        localStartDate = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
        localEndDate = LocalDateTime.of(2020, 6, 14, 18, 30,  0);
        Prices prices2 = Prices.builder().price(BigDecimal.valueOf(35.0))
                .endDate(localEndDate)
                .startDate(localStartDate)
                .brand(new Brand(2L, "Hm", ""))
                .product(new Product(35455L, "Camiseta", ""))
                .priceList(new PriceList(2L, "Rebajas Navidad", ""))
                .priority(1)
                .price(BigDecimal.valueOf(25.45))
                .build();

        return List.of(prices1, prices2);
    }

}