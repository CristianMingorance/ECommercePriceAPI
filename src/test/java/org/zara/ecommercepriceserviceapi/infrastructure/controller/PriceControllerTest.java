package org.zara.ecommercepriceserviceapi.infrastructure.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PriceControllerTest {

  @Autowired private MockMvc mockMvc;

  // Test 1: Verifica el precio a las 10:00 del día 14 para el producto 35455 de la marca 1 (ZARA).
  @Test
  void testFindPriceAt1000June14() throws Exception {
    mockMvc
        .perform(get("/prices/1/35455/2020-06-14T10:00:00"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(35.50))
        .andExpect(jsonPath("$.priceList").value(1));
  }

  // Test 2: Verifica el precio a las 16:00 del día 14 para el producto 35455 de la marca 1 (ZARA).
  @Test
  void testFindPriceAt1600June14() throws Exception {
    mockMvc
        .perform(get("/prices/1/35455/2020-06-14T16:00:00"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(25.45))
        .andExpect(jsonPath("$.priceList").value(2));
  }

  // Test 3: Verifica el precio a las 21:00 del día 14 para el producto 35455 de la marca 1 (ZARA).
  @Test
  void testFindPriceAt2100June14() throws Exception {
    mockMvc
        .perform(get("/prices/1/35455/2020-06-14T21:00:00"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(35.50))
        .andExpect(jsonPath("$.priceList").value(1));
  }

  // Test 4: Verifica el precio a las 10:00 del día 15 para el producto 35455 de la marca 1 (ZARA).
  @Test
  void testFindPriceAt1000June15() throws Exception {
    mockMvc
        .perform(get("/prices/1/35455/2020-06-15T10:00:00"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(30.50))
        .andExpect(jsonPath("$.priceList").value(3));
  }

  // Test 5: Verifica el precio a las 21:00 del día 16 para el producto 35455 de la marca 1 (ZARA).
  @Test
  void testFindPriceAt2100June16() throws Exception {
    mockMvc
        .perform(get("/prices/1/35455/2020-06-16T21:00:00"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.price").value(38.95))
        .andExpect(jsonPath("$.priceList").value(4));
  }
}
