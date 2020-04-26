package com.sda.springapporderclient.service;

import com.sda.springapporderclient.exception.OrderNotFoundException;
import com.sda.springapporderclient.exception.ProductNotFoundException;
import com.sda.springapporderclient.model.Order;
import com.sda.springapporderclient.model.Product;
import com.sda.springapporderclient.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    public Order getOrder(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public Order updateOrder(Long id, Order order) {
        Order toEdited = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        toEdited.setUser(order.getUser());
        toEdited.setOrderDate(LocalDateTime.now());
        toEdited.setProductList(order.getProductList());
        return orderRepository.save(toEdited);
    }

    public void deleteOrder(Long id) {
        Order toDelete = orderRepository.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
        orderRepository.delete(toDelete);
    }
}
