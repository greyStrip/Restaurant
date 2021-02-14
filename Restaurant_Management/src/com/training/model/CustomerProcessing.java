package com.training.model;

import java.util.Map;

public class CustomerProcessing {
	Customer customer;
	Seat seat;
	Waiter waiter;
	Cook cook;
	Map<Dish, Integer> dishes;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Waiter getWaiter() {
		return waiter;
	}
	public void setWaiter(Waiter waiter) {
		this.waiter = waiter;
	}
	public Cook getCook() {
		return cook;
	}
	public void setCook(Cook cook) {
		this.cook = cook;
	}
	public Map<Dish, Integer> getDishes() {
		return dishes;
	}
	public void setDishes(Map<Dish, Integer> dishes) {
		this.dishes = dishes;
	}
	
	
}
