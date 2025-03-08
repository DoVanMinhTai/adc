package com.adc.cart.repository;

import com.adc.cart.model.CartItem;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @QueryHints({@QueryHint(name = "jakarta.persistence.lock.timeout", value = "0")})
    @Query("select c from CartItem c where c.customerId = :customerId and c.productId = :productId")
    Optional<CartItem> findByCustomerIdAndProductId(String customerId, Long productId);
}
