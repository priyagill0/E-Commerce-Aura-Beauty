package com.example.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.backend.model.Customer;
import com.example.backend.model.OrderItem;
import com.example.backend.model.Product;
import com.example.backend.model.ProductVariant;
import com.example.backend.repository.OrderItemRepository;



@Service
public class OrderItemService {
    private final OrderItemRepository repo;
   

    public OrderItemService(OrderItemRepository repo) {
        this.repo = repo;
    }

    public List<OrderItem> getAllOrderItems() {
        return repo.findAll();
    }

    
    public List<OrderItem> getOrderItemByOrderItemId(String orderItemId) {
        return repo.findByOrderItemId(orderItemId);
    }
    public List<OrderItem> getOrderItemByOrderId(String orderId) {
        return repo.findByOrder_OrderId(orderId);
    }

    public OrderItem addOrderItem(OrderItem orderItem) {
        return repo.save(orderItem);
    }
    public List<SalesHistoryDTO> getSalesHistory() {
        List<OrderItem> items = repo.findAll();

        return items.stream()
        .sorted((a, b) -> b.getOrder().getPlacedAt().compareTo(a.getOrder().getPlacedAt()))
        .map(item -> {
            Customer customer = item.getOrder().getCustomer();
            Product product = item.getProductVariant().getProduct();
            ProductVariant variant = item.getProductVariant();

            SalesHistoryDTO dto = new SalesHistoryDTO();
            dto.setOrderId(item.getOrder().getOrderId());
            dto.setCustomerName(customer.getEmail());
            dto.setProductName(product.getName());
            dto.setVariantSize(variant.getSize());
            dto.setQuantity(item.getQty());
            dto.setProductPrice(item.getProductPrice());
            dto.setTotal(item.getQty() * item.getProductPrice());
            dto.setStatus(item.getOrder().getStatus());
            dto.setPlacedAt(item.getOrder().getPlacedAt());

            return dto;
        }).toList();
    }

}