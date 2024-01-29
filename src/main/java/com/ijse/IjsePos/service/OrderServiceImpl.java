package com.ijse.IjsePos.service;

import com.ijse.IjsePos.dto.OrderDTO;
import com.ijse.IjsePos.entity.Order;
import com.ijse.IjsePos.repository.ItemRepository;
import com.ijse.IjsePos.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order createOrder(List<OrderDTO> orderDTOList) {

        return null;
    }
}
