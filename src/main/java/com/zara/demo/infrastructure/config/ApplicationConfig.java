package com.zara.demo.infrastructure.config;

import com.zara.demo.application.services.PricesService;
import com.zara.demo.application.usecases.RetrievePricesUseCaseImpl;
import com.zara.demo.domain.ports.out.PricesRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {


    @Bean
    public PricesService pricesService(PricesRepositoryPort pricesRepositoryPort){
	return new PricesService(new RetrievePricesUseCaseImpl(pricesRepositoryPort));

    }



}
