package org.zara.ecommercepriceserviceapi.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zara.ecommercepriceserviceapi.domain.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

  List<Price>
      findByProductIdAndBrandIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
          Integer productId, Integer brandId, LocalDateTime startDate, LocalDateTime endDate);
}
