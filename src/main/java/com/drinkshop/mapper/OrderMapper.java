package com.drinkshop.mapper;

import com.drinkshop.dto.OrderDTO;
import com.drinkshop.model.Order;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    @Autowired
    ModelMapper modelMapper;

    public List<OrderDTO> toDTOs(List<Order> list) {
        List<OrderDTO> result = new ArrayList<>();
        for (Order order : list) {
            result.add(modelMapper.map(order, OrderDTO.class));
        }
        return result;
    }
}
