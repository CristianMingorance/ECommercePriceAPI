package org.zara.ecommercepriceserviceapi.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.zara.ecommercepriceserviceapi.application.dto.PriceDTO;
import org.zara.ecommercepriceserviceapi.domain.entity.Price;

@Mapper(componentModel = "spring")
public interface PriceMapper {

  PriceDTO priceToPriceDto(Price price);

  Price priceDtoToPrice(PriceDTO priceDto);

  @Mapping(target = "productId", source = "productId")
  @Mapping(target = "brandId", source = "brandId")
  @Mapping(target = "priceList", source = "priceList")
  @Mapping(target = "startDate", source = "startDate")
  @Mapping(target = "endDate", source = "endDate")
  @Mapping(target = "price", source = "price")
  @Mapping(target = "id", ignore = true)
  @Mapping(target = "priority", ignore = true)
  @Mapping(target = "curr", ignore = true)
  PriceDTO toApplicablePriceResponse(Price price);
}
