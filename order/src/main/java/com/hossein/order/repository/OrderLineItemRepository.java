package com.hossein.order.repository;

import com.hossein.order.entity.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem,Long> {
}
