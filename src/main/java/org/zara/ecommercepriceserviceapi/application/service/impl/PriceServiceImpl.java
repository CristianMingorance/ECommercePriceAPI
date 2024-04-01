package org.zara.ecommercepriceserviceapi.application.service.impl;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zara.ecommercepriceserviceapi.application.dto.PriceDTO;
import org.zara.ecommercepriceserviceapi.application.exception.ResourceNotFoundException;
import org.zara.ecommercepriceserviceapi.application.mapper.PriceMapper;
import org.zara.ecommercepriceserviceapi.application.service.PriceService;
import org.zara.ecommercepriceserviceapi.domain.repository.PriceRepository;

@RequiredArgsConstructor
@Service
public class PriceServiceImpl implements PriceService {

  private final PriceRepository priceRepository;
  private final PriceMapper priceMapper;

  @Override
  public PriceDTO findApplicablePrice(LocalDateTime applicationDate, int productId, int brandId) {
    return priceRepository
        .findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
            productId, brandId, applicationDate, applicationDate)
        .stream()
        .findFirst()
        .map(priceMapper::toApplicablePriceResponse)
        .orElseThrow(
            () ->
                new ResourceNotFoundException(
                    String.format(
                        "No applicable price found for product ID %d and brand ID %d at %s",
                        productId, brandId, applicationDate.toString())));
  }

}
