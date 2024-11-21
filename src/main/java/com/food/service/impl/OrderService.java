package com.food.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.dto.OrderDto;
import com.food.entity.Order;
import com.food.entity.OrderStatus;
import com.food.entity.User;
import com.food.repo.OrderRepo;
import com.food.repo.UserRepo;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

    // @Autowired
    // private OrderRepo orderRepo;;

    // @Autowired
    // private UserRepo userRepo;

    // @Autowired
    // private MenuItemRepo menuItemRepo;
    // @Autowired
    // private ModelMapper modelMapper;

    // public OrderDto placeOrder(OrderDto orderDto) {
    // Order order = modelMapper.map(orderDto, Order.class);

    // User userId = userRepo.findById(orderDto.getUserId()).orElse(null);

    // if (userId != null) {
    // order.setUserId(userId);
    // }
    // order = orderRepo.save(order);
    // orderDto = modelMapper.map(order, OrderDto.class);
    // return orderDto;
    // }

    // public OrderDto getOrder(long id) {
    // Optional<Order> orderOpt = orderRepo.findById(id);
    // return (OrderDto) orderOpt.map(order -> modelMapper.map(order,
    // OrderDto.class))
    // .orElse(null);

    // }

    // public OrderDto updateOrders(OrderDto orderDto, long id, OrderStatus status)
    // {
    // if (orderRepo.existsById(id)) {
    // Order order = modelMapper.map(orderDto, Order.class);
    // order.setStatus(status);
    // Order updateOrder = orderRepo.save(order);
    // return modelMapper.map(updateOrder, OrderDto.class);

    // } else {
    // return null;
    // }

    // }

    // public Double calculationPrice(List<OrderItem> orderItems) {
    // double totalprice = 0;

    // for (OrderItem orderItem : orderItems) {
    // totalprice = orderItem.getPrice() * orderItem.getQuantity();
    // }
    // return totalprice;
    // }

    // @Transactional
    // public OrderDto createOrder(Long userId, List<Long> menuItemIds, String
    // deliveryAddress, String paymentMethod) {
    // // Fetch customer details
    // User user = userRepo.findById(userId)
    // .orElseThrow(() -> new IllegalArgumentException("Customer not found"));

    // // Fetch menu items for the order
    // List<MenuItem> menuItems = menuItemRepo.findAllById(menuItemIds);

    // // Calculate the total price of the order
    // double totalPrice = menuItems.stream()
    // .mapToDouble(MenuItem::getPrice)
    // .sum();

    // // Create a new order
    // Order order = new Order();
    // order.setUserId(user);
    // order.setMenuItems(menuItems);
    // order.setTotalPrice(totalPrice);
    // order.setStatus(OrderStatus.PENDING);
    // order.setDeliveryAddress(deliveryAddress);
    // order.setPaymentMethod(paymentMethod);
    // order.setOrderDate(String.valueOf(System.currentTimeMillis())); // Set
    // current timestamp as order date

    // // Save the order
    // Order savedOrder = orderRepo.save(order);

    // // Convert saved order entity to DTO
    // return modelMapper.map(savedOrder, OrderDto.class);
    // }

    // // Update the status of an order
    // @Transactional
    // public OrderDto updateOrderStatus(Long orderId, OrderStatus status) {
    // Order order = orderRepo.findById(orderId)
    // .orElseThrow(() -> new IllegalArgumentException("Order not found"));

    // order.setStatus(status);
    // Order updatedOrder = orderRepo.save(order);

    // // Convert updated order entity to DTO
    // return modelMapper.map(updatedOrder, OrderDto.class);
    // }

    // // Find an order by its ID
    // public OrderDto getOrderById(Long orderId) {
    // Order order = orderRepo.findById(orderId)
    // .orElseThrow(() -> new IllegalArgumentException("Order not found"));

    // // Convert order entity to DTO
    // return modelMapper.map(order, OrderDto.class);
    // }

    // // Get all orders for a customer
    // public List<OrderDto> getOrdersByCustomerId(Long customerId) {
    // List<Order> orders = orderRepo.findby(customerId);

    // // Convert list of orders to list of DTOs
    // return orders.stream()
    // .map(order -> modelMapper.map(order, OrderDto.class))
    // .collect(Collectors.toList());
    // }

    // // Calculate the total price of an order
    // public double calculateTotalPrice(List<MenuItem> menuItems) {
    // return menuItems.stream()
    // .mapToDouble(MenuItem::getPrice)
    // .sum();
    // }

    // // Delete an order (e.g., for cancellation)
    // @Transactional
    // public void deleteOrder(Long orderId) {
    // if (orderRepo.existsById(orderId)) {
    // orderRepo.deleteById(orderId);
    // } else {
    // throw new IllegalArgumentException("Order not found");
    // }
    // }
    // }

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper; // Inject ModelMapper

    // Create a new order from DTO
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = modelMapper.map(orderDto, Order.class);

        User userId = userRepo.findById(orderDto.getUserId()).orElse(null);

        if (userId != null) {
            order.setUserId(userId);
        }
        order = orderRepo.save(order);
        orderDto = modelMapper.map(order, OrderDto.class);
        return orderDto;
    }

    // Update the status of an order
    @Transactional
    public Order updateOrderStatus(Long orderId, OrderStatus status) {
        Order order = orderRepo.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));

        order.setStatus(status);
        return orderRepo.save(order);
    }

    // Get an order by its ID
    public Order getOrderById(Long orderId) {
        return orderRepo.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("Order not found"));
    }

    // Delete an order
    @Transactional
    public void deleteOrder(Long orderId) {
        if (orderRepo.existsById(orderId)) {
            orderRepo.deleteById(orderId);
        } else {
            throw new IllegalArgumentException("Order not found");
        }
    }
}