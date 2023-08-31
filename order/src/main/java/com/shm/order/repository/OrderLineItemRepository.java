package com.shm.order.repository;

import com.shm.order.entity.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem,Long> {
}
