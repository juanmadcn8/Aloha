package com.example.aloha.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ViewAccommodationUnit {
    private Long id;
    private Integer capacity;
    private Integer number;
    private Double price;
    private Integer accommodation_id;
    private Integer id_extra;
    private Integer accommodation_unit_id;
    private Integer category_id;
}
