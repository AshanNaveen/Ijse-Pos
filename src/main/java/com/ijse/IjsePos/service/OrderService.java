package com.ijse.IjsePos.service;

import com.ijse.IjsePos.dto.OrderDTO;
import com.ijse.IjsePos.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order createOrder(List<OrderDTO> orderDTOList);
}
