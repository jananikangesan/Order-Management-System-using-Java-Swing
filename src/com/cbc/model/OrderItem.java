/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cbc.model;

/**
 *
 * @author admin
 */
public class OrderItem {
    
    private String itemId;
    private String description;
    private int quantity;
    private double unitPrice;
    private double amount;
    
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(String itemId, String description, int quantity, double unitPrice, double amount) {
		super();
		this.itemId = itemId;
		this.description = description;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.amount = amount;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	} 
    
}
