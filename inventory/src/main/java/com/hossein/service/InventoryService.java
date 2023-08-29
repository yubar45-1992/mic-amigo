package com.hossein.service;

import com.hossein.dto.InventoryRequestDto;
import com.hossein.dto.InventoryResponseDto;
import com.hossein.entity.Inventory;
import com.hossein.repository.InventoryRepository;
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
