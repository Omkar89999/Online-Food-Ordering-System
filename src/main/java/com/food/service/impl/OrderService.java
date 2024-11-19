package com.food.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.OrderDto;
import com.food.entity.Order;
import com.food.entity.OrderItem;
import com.food.entity.User;
import com.food.repo.OrderRepo;
import com.food.repo.UserRepo;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public OrderDto placeOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);

        User userId = userRepo.findById(orderDto.getUserId()).orElse(null);

        if (userId != null) {
            order.setUserId(userId);
        }
        order = orderRepo.save(order);
        orderDto = modelMapper.map(order, OrderDto.class);
        return orderDto;
    }

    public OrderDto getOrder(long id) {
        Optional<Order> orderOpt = orderRepo.findById(id);
        return (OrderDto) orderOpt.map(order -> modelMapper.map(order, OrderDto.class))
                .orElse(null);

    }

    public OrderDto updateOrders(OrderDto orderDto, long id, String status) {
        if (orderRepo.existsById(id)) {
            Order order = modelMapper.map(orderDto, Order.class);
            order.setOrderStatus(status);
            Order updateOrder = orderRepo.save(order);
            return modelMapper.map(updateOrder, OrderDto.class);

        } else {
            return null;
        }

    }

    public Double calculationPrice(List<OrderItem> orderItems) {
        double totalprice = 0;

        for (OrderItem orderItem : orderItems) {
            totalprice = orderItem.getPrice() * orderItem.getQuantity();
        }
        return totalprice;
    }
}
