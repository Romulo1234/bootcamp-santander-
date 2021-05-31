package com.project.bootcamp.mapper;

import com.project.bootcamp.mode.dto.StockDTO;
import com.project.bootcamp.mode.stock;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class stockmapper {
    public stock toEntity(StockDTO dto) {
        stock stock =new stock();
        stock.setName(dto.getName());
        stock.setId(dto.getId());
        stock.setPrice(dto.getPrice());
        stock.setVariation(dto.getVariation());
        stock.setDate(dto.getDate());
        return stock;
    }
    public StockDTO toDTO(stock stock){
        StockDTO dto =new StockDTO();
        dto.setName(stock.getName());
        dto.setId(stock.getId());
        dto.setPrice(stock.getPrice());
        dto.setVariation(stock.getVariation());
        dto.setDate(stock.getDate());
        return dto;
    }

    public List<StockDTO> toDTO(List<stock>listStock){
        return listStock.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
