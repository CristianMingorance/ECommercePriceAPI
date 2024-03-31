package org.zara.ecommercepriceserviceapi.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.zara.ecommercepriceserviceapi.application.dto.PriceDTO;
import org.zara.ecommercepriceserviceapi.infrastructure.persistence.entity.Price;

@Mapper(componentModel = "spring")
public interface PriceMapper {

  @Mapping(target = "priceList", source = "priceList")
  PriceDTO priceToPriceDto(Price price);

  @Mapping(target = "priceList", source = "priceList")
  Price priceDtoToPrice(PriceDTO priceDto);
}
