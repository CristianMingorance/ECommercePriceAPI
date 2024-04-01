package org.zara.ecommercepriceserviceapi.infrastructure.controller;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zara.ecommercepriceserviceapi.application.dto.PriceDTO;
import org.zara.ecommercepriceserviceapi.application.service.PriceService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/prices")
public class PriceController {

  private final PriceService priceService;

  @GetMapping("/{brandId}/{productId}/{applicationDate}")
  public ResponseEntity<PriceDTO> findApplicablePrice(
          @PathVariable("brandId") int brandId,
          @PathVariable("productId") int productId,
          @PathVariable("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {
    PriceDTO price = priceService.findApplicablePrice(applicationDate, productId, brandId);
    return ResponseEntity.ok(price);
  }
}
