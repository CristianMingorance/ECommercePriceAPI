package org.zara.ecommercepriceserviceapi.application.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.zara.ecommercepriceserviceapi.application.dto.PriceDTO;
import org.zara.ecommercepriceserviceapi.application.mapper.PriceMapper;
import org.zara.ecommercepriceserviceapi.domain.entity.Price;
import org.zara.ecommercepriceserviceapi.domain.repository.PriceRepository;
import org.zara.ecommercepriceserviceapi.utils.TestUtils;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

  @Mock private PriceRepository priceRepository;

  @Mock private PriceMapper priceMapper;

  @InjectMocks private PriceServiceImpl priceService;

  // Test 1: Verificar el precio y la tarifa aplicable a las 10:00 del día 14
  @Test
  void testFindApplicablePrice_10_00_14() {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 10, 0);
    setupAndAssertPrice(applicationDate, BigDecimal.valueOf(35.50), 1);
  }

  // Test 2: Verificar el precio y la tarifa aplicable a las 16:00 del día 14
  @Test
  void testFindApplicablePrice_16_00_14() {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 16, 0);
    setupAndAssertPrice(applicationDate, BigDecimal.valueOf(25.45), 2);
  }

  // Test 3: Verificar el precio y la tarifa aplicable a las 21:00 del día 14
  @Test
  void testFindApplicablePrice_21_00_14() {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 14, 21, 0);
    setupAndAssertPrice(applicationDate, BigDecimal.valueOf(35.50), 1);
  }

  // Test 4: Verificar el precio y la tarifa aplicable a las 10:00 del día 15
  @Test
  void testFindApplicablePrice_10_00_15() {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 15, 10, 0);
    setupAndAssertPrice(applicationDate, BigDecimal.valueOf(30.50), 3);
  }

  // Test 5: Verificar el precio y la tarifa aplicable a las 21:00 del día 16
  @Test
  void testFindApplicablePrice_21_00_16() {
    LocalDateTime applicationDate = LocalDateTime.of(2020, 6, 16, 21, 0);
    setupAndAssertPrice(applicationDate, BigDecimal.valueOf(38.95), 4);
  }

  private void setupAndAssertPrice(
      LocalDateTime applicationDate, BigDecimal expectedPrice, int priceList) {
    int productId = 35455;
    int brandId = 1;
    Price price =
        TestUtils.createPriceForTest(
            priceList,
            brandId,
            applicationDate.minusHours(1),
            applicationDate.plusHours(1),
            productId,
            1,
            expectedPrice,
            "EUR");
    PriceDTO expectedPriceDto =
        TestUtils.createPriceDTOForTest(
            priceList,
            brandId,
            applicationDate.minusHours(1),
            applicationDate.plusHours(1),
            productId,
            1,
            expectedPrice,
            "EUR");

    when(priceRepository
            .findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
                productId, brandId, applicationDate, applicationDate))
        .thenReturn(List.of(price));
    when(priceMapper.toApplicablePriceResponse(any(Price.class))).thenReturn(expectedPriceDto);

    PriceDTO actualPriceDto = priceService.findApplicablePrice(applicationDate, productId, brandId);

    assertEquals(0, expectedPriceDto.getPrice().compareTo(actualPriceDto.getPrice()));
    assertEquals(expectedPriceDto.getPriceList(), actualPriceDto.getPriceList());
  }
}
