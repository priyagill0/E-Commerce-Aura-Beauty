package com.example.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.model.OrderItem;

import com.example.backend.service.OrderItemService;
import com.example.backend.service.SalesHistoryDTO;



@RestController
@RequestMapping("/api/order-item")
public class OrderItemController {
    
    private final OrderItemService service;

    public OrderItemController(OrderItemService service) {
        this.service = service;
    }

    @GetMapping
    public List<OrderItem> getAll() {
        return service.getAllOrderItems();
    }

    // Get variants for a specific product
    @GetMapping("/{orderItemId}")
    public List<OrderItem> getByOrderItemId(@PathVariable String orderItemId) {
        return service.getOrderItemByOrderItemId(orderItemId);
    }

    @GetMapping("/order/{orderId}")
    public List<OrderItem> getByOrderId(@PathVariable String orderId) {
        return service.getOrderItemByOrderId(orderId);
    }

    @GetMapping("/sales-history")
    public List<SalesHistoryDTO> getSalesHistory() {
        // Just delegate to the service
        return service.getSalesHistory();
    }

    @PostMapping
    public OrderItem add(@RequestBody OrderItem orderItem) {
        return service.addOrderItem(orderItem);
    }
}
