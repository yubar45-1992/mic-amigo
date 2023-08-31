package com.shm.service;

import com.shm.dto.InventoryRequestDto;
import com.shm.dto.InventoryResponseDto;
import com.shm.entity.Inventory;
import com.shm.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepository inventoryRepository;


    public List<InventoryResponseDto> isInStock(List<String> skuCodes) {
        return inventoryRepository.findBySkuCodeIn(skuCodes)
                .stream()
                .map(inventory -> InventoryResponseDto.builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0)
                        .build())
                .toList();
    }

    @Transactional
    public void save(InventoryRequestDto inventoryRequestDto) {
        inventoryRepository.save(Inventory.builder()
                .skuCode("galaxy s21")
                .quantity(25)
                .build());
    }
}
