package com.controller;

import java.util.List;
public interface CartDAO 
{
	public void add(CartItem cartItem);
	public CartItem get(int id);
	public List getAllItems();
	public void remove(int id);
	public void removeAll();
	public void update(int cartItemId,int quantity);
	
}
