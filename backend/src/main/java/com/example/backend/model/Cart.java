package com.example.backend.model;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Cart {

	@Id
	@GeneratedValue
	@Column(columnDefinition = "BINARY(16)")
	private UUID cartId;


    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;

    private String sessionId;

    @OneToMany(mappedBy="cart", cascade = CascadeType.ALL)
    private List<CartItem> items = new ArrayList<>();

    // getters + setters
    public UUID getCartId() { return cartId; }
    public void setCartId(UUID id) { this.cartId = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.custom