package com.ijse.IjsePos.dto;

import lombok.Data;

@Data
public class ItemDTO {
    private String name;
    private Double price;
    private Double qty;
    private Long categoryId;
}
