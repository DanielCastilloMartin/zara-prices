package com.zara.demo.infrastructure.mappers;

import com.zara.demo.domain.model.Prices;
import com.zara.demo.infrastructure.entities.PricesEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PricesMapper {

    PricesEntity toEntity(Prices domain);

    @Mapping(source = "entity.product.id", target = "idProduct")
    @Mapping(source = "entity.brand.id", target = "idBrand")
    @Mapping(source = "entity.priceList.id", target = "idPriceList")
    Prices toDomain(PricesEntity entity);

}
