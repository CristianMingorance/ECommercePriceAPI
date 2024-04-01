package org.zara.ecommercepriceserviceapi.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.zara.ecommercepriceserviceapi.application.dto.PriceDTO;
import org.zara.ecommercepriceserviceapi.domain.entity.Price;

public class TestUtils {

  public static Price createPriceForTest(
      Integer priceList,
      Integer brandId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer productId,
      Integer priority,
      BigDecimal price,
      String curr) {
    return Price.builder()
        .priceList(priceList)
        .brandId(brandId)
        .startDate(startDate)
        .endDate(endDate)
        .productId(productId)
        .priority(priority)
        .price(price)
        .curr(curr)
        .build();
  }

  public static PriceDTO createPriceDTOForTest(
      Integer priceList,
      Integer brandId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      Integer productId,
      Integer priority,
      BigDecimal price,
      String curr) {
    return PriceDTO.builder()
        .priceList(priceList)
        .brandId(brandId)
        .startDate(startDate)
        .endDate(endDate)
        .productId(productId)
        .priority(priority)
        .price(price)
        .curr(curr)
        .build();
  }

  public static List<Price> createPriceListForTest(
      int productId,
      int brandId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      BigDecimal price) {
    List<Price> priceList = new ArrayList<>();
    priceList.add(createPriceForTest(1, brandId, startDate, endDate, productId, 1, price, "EUR"));
    return priceList;
  }

  public static List<PriceDTO> createPriceDtoListForTest(
      int productId,
      int brandId,
      LocalDateTime startDate,
      LocalDateTime endDate,
      BigDecimal price) {
    List<PriceDTO> priceDtoList = new ArrayList<>();
    priceDtoList.add(
        createPriceDTOForTest(1, brandId, startDate, endDate, productId, 1, price, "EUR"));
    return priceDtoList;
  }
}
