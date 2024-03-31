package org.zara.ecommercepriceserviceapi.application.service.impl;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zara.ecommercepriceserviceapi.application.dto.PriceDTO;
import org.zara.ecommercepriceserviceapi.application.service.PriceService;
import org.zara.ecommercepriceserviceapi.infrastructure.persistence.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

  private final PriceRepository priceRepository;

  @Autowired
  public PriceServiceImpl(PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  @Override
  public PriceDTO findApplicablePrice(LocalDateTime applicationDate, int productId, int brandId) {

    return null;
  }
}
