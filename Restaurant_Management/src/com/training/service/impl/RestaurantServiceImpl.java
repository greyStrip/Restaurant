package com.training.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.training.enums.Status;
import com.training.model.Cook;
import com.training.model.Restaurant;
import com.training.model.Seat;
import com.training.model.Waiter;
import com.training.service.RestaurantService;

public class RestaurantServiceImpl implements RestaurantService {
	Restaurant restaurant;

	public RestaurantServiceImpl() {
	}

	public RestaurantServiceImpl(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@Override
	public synchronized List<Seat> getAllAvailableSeats() {
		return restaurant.getSeats()
				.stream()
					.filter(seat -> seat.getSeatStatus() == Status.AVAILABLE)
						.collect(Collectors.toList());
	}

	@Override
	public List<Waiter> getAllAvailableWaiters() {
		return restaurant.getWaiters()
			.stream()
				.filter(waiter -> waiter.getWaiterStatus() == Status.AVAILABLE)
					.collect(Collectors.toList());
		
	}
	
	@Override
	public List<Cook> getAllAvailableCooks(){
		return restaurant.getCooks()
				.stream()
					.filter(cook -> cook.getCookStatus()==Status.AVAILABLE)
						.collect(Collectors.toList());
	}
	
}
