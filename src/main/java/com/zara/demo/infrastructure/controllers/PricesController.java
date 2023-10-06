package com.zara.demo.infrastructure.controllers;

import com.zara.demo.application.services.PricesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
@Validated
@AllArgsConstructor
public class PricesController {

    private final PricesService pricesService;

    @GetMapping
    public ResponseEntity<?> getPricesInfo(@RequestParam LocalDateTime applicationTime, @RequestParam Long brandId,
	    @RequestParam Long productId) {

	return ResponseEntity.ok(pricesService.retrievePrices(applicationTime, brandId, productId));
    }
}
