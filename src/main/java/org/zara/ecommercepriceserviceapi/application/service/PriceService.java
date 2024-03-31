package org.zara.ecommercepriceserviceapi.application.service;

import java.time.LocalDateTime;
import org.zara.ecommercepriceserviceapi.application.dto.PriceDTO;

public interface PriceService {
    PriceDTO findApplicablePrice(LocalDateTime applicationDate, int productId, int brandId);
}