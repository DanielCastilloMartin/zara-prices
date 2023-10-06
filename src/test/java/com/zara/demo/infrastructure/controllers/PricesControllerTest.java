package com.zara.demo.infrastructure.controllers;

import com.zara.demo.application.services.PricesService;
import com.zara.demo.domain.model.dto.PricesDto;
import lombok.SneakyThrows;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

class PricesControllerTest {

    private static final String PATH = "/prices";

    private MockMvc mockMvc;

    @Mock
    PricesService pricesService;

    @InjectMocks
    PricesController pricesController;

    @BeforeEach
    void setUp() {
	MockitoAnnotations.openMocks(this);
	mockMvc = MockMvcBuilders.standaloneSetup(pricesController).build();
    }

    @Test
    @SneakyThrows
    void test_prices_test1() {
	var applicationTime = LocalDateTime.of(2020, 6, 14, 10, 0);
	var brandId = 1;
	var productId = 35455;

	var localStartDate = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
	var localEndDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
	var pricesDto = getPricesDto(localStartDate, localEndDate, BigDecimal.valueOf(35.5), 1L);
	when(pricesService.retrievePrices(any(), anyLong(), anyLong())).thenReturn(pricesDto);

	mockMvc.perform(get(PATH).param("applicationTime", String.valueOf(applicationTime))
			.param("brandId", String.valueOf(brandId)).param("productId", String.valueOf(productId))
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.price", closeTo(35.5, 0.001))).andExpect(jsonPath("$.priceListId", is(1)));
    }

    @Test
    @SneakyThrows
    void test_prices_test2() {
	var applicationTime = LocalDateTime.of(2020, 6, 14, 16, 0);
	var brandId = 1;
	var productId = 35455;

	var localStartDate = LocalDateTime.of(2020, 6, 14, 15, 0, 0);
	var localEndDate = LocalDateTime.of(2020, 12, 31, 18, 30, 0);
	var pricesDto = getPricesDto(localStartDate, localEndDate, BigDecimal.valueOf(25.45), 2L);
	when(pricesService.retrievePrices(any(), anyLong(), anyLong())).thenReturn(pricesDto);

	mockMvc.perform(get(PATH).param("applicationTime", String.valueOf(applicationTime))
			.param("brandId", String.valueOf(brandId)).param("productId", String.valueOf(productId))
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.price", closeTo(25.45, 0.001))).andExpect(jsonPath("$.priceListId", is(2)));
    }

    @Test
    @SneakyThrows
    void test_prices_test3() {
	var applicationTime = LocalDateTime.of(2020, 6, 14, 21, 0);
	var brandId = 1;
	var productId = 35455;

	var localStartDate = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
	var localEndDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
	var pricesDto = getPricesDto(localStartDate, localEndDate, BigDecimal.valueOf(35.5), 1L);
	when(pricesService.retrievePrices(any(), anyLong(), anyLong())).thenReturn(pricesDto);

	mockMvc.perform(get(PATH).param("applicationTime", String.valueOf(applicationTime))
			.param("brandId", String.valueOf(brandId)).param("productId", String.valueOf(productId))
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.price", closeTo(35.5, 0.001))).andExpect(jsonPath("$.priceListId", is(1)));
    }

    @Test
    @SneakyThrows
    void test_prices_test4() {
	var applicationTime = LocalDateTime.of(2020, 6, 15, 10, 0);
	var brandId = 1;
	var productId = 35455;

	var localStartDate = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
	var localEndDate = LocalDateTime.of(2020, 6, 15, 0, 0, 0);
	var pricesDto = getPricesDto(localStartDate, localEndDate, BigDecimal.valueOf(30.5), 3L);
	when(pricesService.retrievePrices(any(), anyLong(), anyLong())).thenReturn(pricesDto);

	mockMvc.perform(get(PATH).param("applicationTime", String.valueOf(applicationTime))
			.param("brandId", String.valueOf(brandId)).param("productId", String.valueOf(productId))
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.price", closeTo(30.5, 0.001))).andExpect(jsonPath("$.priceListId", is(3)));
    }

    @Test
    @SneakyThrows
    void test_prices_test5() {
	var applicationTime = LocalDateTime.of(2020, 6, 16, 21, 0);
	var brandId = 1;
	var productId = 35455;

	var localStartDate = LocalDateTime.of(2020, 6, 14, 0, 0, 0);
	var localEndDate = LocalDateTime.of(2020, 12, 31, 23, 59, 59);
	var pricesDto = getPricesDto(localStartDate, localEndDate, BigDecimal.valueOf(38.95), 4L);
	when(pricesService.retrievePrices(any(), anyLong(), anyLong())).thenReturn(pricesDto);

	mockMvc.perform(get(PATH).param("applicationTime", String.valueOf(applicationTime))
			.param("brandId", String.valueOf(brandId)).param("productId", String.valueOf(productId))
			.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.price", closeTo(38.95, 0.001))).andExpect(jsonPath("$.priceListId", is(4)));
    }

    PricesDto getPricesDto(LocalDateTime startDate, LocalDateTime endDate, BigDecimal price, Long priceListId) {
	return new PricesDto(35455L, 1L, price, startDate, priceListId, endDate);
    }

}