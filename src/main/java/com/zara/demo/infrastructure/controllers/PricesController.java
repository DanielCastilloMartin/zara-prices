package com.zara.demo.infrastructure.controllers;

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
public class PricesController {

    @GetMapping
    public ResponseEntity<?> getPricesInfo(@RequestParam LocalDateTime applicationTime, @RequestParam Long brandId,
	    @RequestParam Long productId) {

	return ResponseEntity.ok("Datos obtenidos correctamente");
    }
}
