package model;

import java.util.List;

public class Restaurant {
	private String name;
	private List<Cook> cooks;
	private List<Seat> seats;
	private List<Waiter> waiters;
	private Dish dishes;
	
	public Restaurant() {
	}

	public Restaurant(String name, List<Cook> cooks, List<Seat> seats, List<Waiter> waiters) {
		this.name = name;
		this.cooks = cooks;
		this.seats = seats;
		this.waiters = waiters;
	}

	public Restaurant(String name, List<Cook> cooks, List<Seat> seats, List<Waiter> waiters, Dish dishes) {
		this.name = name;
		this.cooks = cooks;
		this.seats = seats;
		this.waiters = waiters;
		this.dishes = dishes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Cook> getCooks() {
		return cooks;
	}

	public void setCooks(List<Cook> cooks) {
		this.cooks = cooks;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public List<Waiter> getWaiters() {
		return waiters;
	}

	public void setWaiters(List<Waiter> waiters) {
		this.waiters = waiters;
	}

	public Dish getDishes() {
		return dishes;
	}

	public void setDishes(Dish dishes) {
		this.dishes = dishes;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", cooks=" + cooks + ", seats=" + seats + ", waiters=" + waiters
				+ ", dishes=" + dishes + "]";
	}

}
