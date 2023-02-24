package com.drinkshop.services.impl;

import com.drinkshop.dto.AddressDTO;
import com.drinkshop.model.OrderExtraData;
import com.drinkshop.repository.OrderExtraDataRepository;
import com.drinkshop.services.IOrderExtraDataService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderExtraDataService implements IOrderExtraDataService {

    @Autowired
    OrderExtraDataRepository orderExtraDataRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public AddressDTO findById(int id) {
        return modelMapper.map(orderExtraDataRepository.findById(id), AddressDTO.class);
    }

    @Override
    public Integer saveOrUpdate(OrderExtraData address) {
        if (address.getId() == null || address.getId() <= 0)
            return orderExtraDataRepository.save(address).getId();
        return null;
    }
}
