package com.hossein.resource;

import com.hossein.dto.InventoryRequestDto;
import com.hossein.dto.InventoryResponseDto;
import com.hossein.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/inventory-service")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponseDto> isInStock(@RequestParam(required = false ,name = "skuCodes") List<String> skuCodes){
        return inventoryService.isInStock(skuCodes);

    }
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
    public void insertInventory(@RequestBody InventoryRequestDto inventoryRequestDto){
        inventoryService.save(inventoryRequestDto);
    }
}
