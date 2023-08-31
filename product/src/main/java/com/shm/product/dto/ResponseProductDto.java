package com.shm.product.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseProductDto {

    private String id;
    private String name;
    private String description;
    private String price;
}
