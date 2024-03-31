package org.zara.ecommercepriceserviceapi.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zara.ecommercepriceserviceapi.infrastructure.persistence.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
}