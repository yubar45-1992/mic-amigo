package com.shm.repository;

import com.shm.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository  extends JpaRepository<Inventory,Integer> {

    List<Inventory> findBySkuCodeIn(List<String> skuCodes);


}
