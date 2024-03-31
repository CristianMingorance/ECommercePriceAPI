package org.zara.ecommercepriceserviceapi.infrastructure.controller;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zara.ecommercepriceserviceapi.application.dto.PriceDTO;
import org.zara.ecommercepriceserviceapi.application.service.PriceService;

@RestController
@RequestMapping("/prices")
public class PriceController {

  private final PriceService priceService;

  @Autowired
  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }

  @GetMapping("/{brandId}/{productId}/{applicationDate}")
  public ResponseEntity<PriceDTO> findPrice(
      @PathVariable int brandId,
      @PathVariable int productId,
      @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
          LocalDateTime applicationDate) {
    PriceDTO priceDto = priceService.findApplicablePrice(applicationDate, productId, brandId);
    if (priceDto != null) {
      return ResponseEntity.ok(priceDto);
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}
