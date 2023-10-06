package com.zara.demo.infrastructure.mappers;

import com.zara.demo.domain.model.Prices;
import com.zara.demo.infrastructure.entities.PricesEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PricesMapper {

    Prices toDomain(PricesEntity entity);

}
