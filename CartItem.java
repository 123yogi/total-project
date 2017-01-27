package com.controller;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class CartItem 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "cartItemId")	
	public int cartItemId;
	@ManyToOne
	@JoinColumn(name="cartId")
	public Cart cart;
	public int chairId;
	@Column(name = "chairName")
	public String chairName;
	@Column(name = "chairPrice")
	int chairPrice;
	@Column(name="chairDesc")
	String chairDesc;
	@Column(name="chairStyle")
	String chairStyle;
	@Column(name="quantity")
	int quantity;
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	public int getChairId() {
		return chairId;
	}
	public void setChairId(int chairId) {
		this.chairId = chairId;
	}
	public String getChairName() {
		return chairName;
	}
	public void setChairName(String chairName) {
		this.chairName = chairName;
	}
	public int getChairPrice() {
		return chairPrice;
	}
	public void setChairPrice(int chairPrice) {
		this.chairPrice = chairPrice;
	}
	public String getChairDesc() {
		return chairDesc;
	}
	public void setChairDesc(String chairDesc) {
		this.chairDesc = chairDesc;
	}
	public String getChairStyle() {
		return chairStyle;
	}
	public void setChairStyle(String chairStyle) {
		this.chairStyle = chairStyle;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}