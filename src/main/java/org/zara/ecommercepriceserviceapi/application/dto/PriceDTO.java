package org.zara.ecommercepriceserviceapi.application.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PriceDTO {

  private Long id;
  private Integer productId;
  private Integer brandId;
  private Integer priceList;
  private LocalDateTime startDate;
  private LocalDateTime endDate;
  private BigDecimal price;
  private Integer priority;
  private String curr;

}
